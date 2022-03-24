package com.example.dataprocessing.controllers;

import com.example.dataprocessing.models.PokemonInfoModel;
import com.example.dataprocessing.repositories.PokemonInfoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pokemonInfos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class PokemonInfoController {
    @Autowired
    private PokemonInfoRepository service;

    @CrossOrigin
    @GetMapping
    @ApiOperation(
            value = "gets all object from the database",
            notes = "This is an select all.",
            response = List.class)
    public Iterable<PokemonInfoModel> findAllPokemons() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ApiOperation(
            value = "gets the objects with the specific id from the database",
            notes = "This selects all the items with that id from the database.",
            response = PokemonInfoModel.class)
    public ResponseEntity<PokemonInfoModel> findPokemonById(@ApiParam(value = "Het id van de pokemon") @PathVariable(value = "id") Integer id) {
        Optional<PokemonInfoModel> Pokemon = service.findById(id);

        return Pokemon.map(pokemonStrategyModel -> ResponseEntity.ok().body(pokemonStrategyModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value = "Creates a new entry in the database.",
            response = PokemonInfoModel.class)
    public PokemonInfoModel create(@Valid @RequestBody PokemonInfoModel pokemonInfoModel) {
        return service.save(pokemonInfoModel);
    }@PutMapping("/{id}")
    @ApiOperation(
            value = "updatess the objects with the specific id from the database",
            notes = "This updates the row with the searched id.",
            response = PokemonInfoModel.class)
    public PokemonInfoModel replacePokemonStrategy(@RequestBody @ApiParam(value = "Update pokemon with the id") @PathVariable PokemonInfoModel pokemonInfoModel,Integer id) {
        return service.findById(id)
                .map(pokemon -> {
                    pokemon.setId(pokemonInfoModel.getId());
                    pokemon.setPokedexNumber(pokemonInfoModel.getPokedexNumber());
                    pokemon.setName(pokemonInfoModel.getName());
                    pokemon.setClassification(pokemonInfoModel.getClassification());
                    pokemon.setAlternateForm(pokemonInfoModel.getAlternateForm());
                    pokemon.setOrignal(pokemonInfoModel.getOrignal());
                    pokemon.setLegendary(pokemonInfoModel.getLegendary());
                    pokemon.setHeight(pokemonInfoModel.getHeight());
                    pokemon.setWeight(pokemonInfoModel.getWeight());
                    pokemon.setPrimaryType(pokemonInfoModel.getPrimaryType());
                    return service.save(pokemon);
                })
                .orElseGet(() -> {
                    pokemonInfoModel.setId(id);
                    return service.save(pokemonInfoModel);
                });
    }
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes an item with a specific id.")
    void deletePokemonStrategy(@ApiParam(value = "Delete an row with a specific id.") @PathVariable Integer id) {
        service.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
