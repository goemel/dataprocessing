package com.example.dataprocessing.controllers;

import com.example.dataprocessing.models.PokemonInfoModel;
import com.example.dataprocessing.models.PokemonOriginModel;
import com.example.dataprocessing.repositories.PokemonOriginRepository;
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
@RequestMapping(value = "/pokemonOrigins", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class PokemonOriginController {
    @Autowired
    private PokemonOriginRepository service;

    @GetMapping
    @ApiOperation(
            value = "gets all object from the database",
            notes = "This is an select all.",
            response = List.class)
    public Iterable<PokemonOriginModel> findAllPokemons() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ApiOperation(
            value = "gets the objects with the specific id from the database",
            notes = "This selects all the items with that id from the database.",
            response = PokemonInfoModel.class)
    public ResponseEntity<PokemonOriginModel> findPokemonById(@ApiParam(value = "Update pokemon with the id") @PathVariable(value = "index") Integer id) {
        Optional<PokemonOriginModel> Pokemon = service.findById(id);

        return Pokemon.map(pokemonOriginModel -> ResponseEntity.ok().body(pokemonOriginModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value = "Creates a new entry in the database.",
            response = PokemonInfoModel.class)
    public PokemonOriginModel create(@Valid @RequestBody @ApiParam(value = "Update pokemon with the id") PokemonOriginModel pokemonOriginModel) {
        return service.save(pokemonOriginModel);
    }@PutMapping("/{id}")
    @ApiOperation(
            value = "updatess the objects with the specific id from the database",
            notes = "This updates the row with the searched id.",
            response = PokemonInfoModel.class)
    public PokemonOriginModel replacePokemonOrigin(@RequestBody PokemonOriginModel pokemonOriginModel, @ApiParam(value = "Update pokemon with the id") @PathVariable Integer id) {
        return service.findById(id)
                .map(pokemon -> {
                    pokemon.setIndex(pokemonOriginModel.getIndex());
                    pokemon.setPokedex_number(pokemonOriginModel.getPokedex_number());
                    pokemon.setName(pokemonOriginModel.getName());
                    pokemon.setGerman_name(pokemonOriginModel.getGerman_name());
                    pokemon.setJapanese_name(pokemonOriginModel.getJapanese_name());
                    pokemon.setGeneration(pokemonOriginModel.getGeneration());
                    pokemon.setIs_mythical(pokemonOriginModel.getIs_mythical());
                    pokemon.setIs_sub_legendary(pokemonOriginModel.getIs_sub_legendary());
                    pokemon.setIs_legendary(pokemonOriginModel.getIs_legendary());
                    pokemon.setSpecies(pokemonOriginModel.getSpecies());
                    return service.save(pokemon);
                })
                .orElseGet(() -> {
                    pokemonOriginModel.setIndex(id);
                    return service.save(pokemonOriginModel);
                });
    }
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes an item with a specific id.")
    void deletePokemonOrigin(@PathVariable @ApiParam(value = "Update pokemon with the id") Integer id) {
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
