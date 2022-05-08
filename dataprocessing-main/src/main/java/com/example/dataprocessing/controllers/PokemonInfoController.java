package com.example.dataprocessing.controllers;

import com.example.dataprocessing.exceptions.ResourceNotfoundException;
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
    public PokemonInfoModel replacePokemonStrategy(@RequestBody @ApiParam(value = "Id of the pokemon that you want to update") @PathVariable(value = "id") int pokemonInfoId, @Valid @RequestBody PokemonInfoModel pokemonInfoModelDetails) throws ResourceNotfoundException {
        return service.findById(pokemonInfoId)
                .map(pokemon -> {
                    pokemon.setId(pokemonInfoModelDetails.getId());
                    pokemon.setPokedexNumber(pokemonInfoModelDetails.getPokedexNumber());
                    pokemon.setName(pokemonInfoModelDetails.getName());
                    pokemon.setClassification(pokemonInfoModelDetails.getClassification());
                    pokemon.setAlternateForm(pokemonInfoModelDetails.getAlternateForm());
                    pokemon.setOrignal(pokemonInfoModelDetails.getOrignal());
                    pokemon.setLegendary(pokemonInfoModelDetails.getLegendary());
                    pokemon.setHeight(pokemonInfoModelDetails.getHeight());
                    pokemon.setWeight(pokemonInfoModelDetails.getWeight());
                    pokemon.setPrimaryType(pokemonInfoModelDetails.getPrimaryType());
                    return service.save(pokemon);
                })
                .orElseThrow(() -> new ResourceNotfoundException("There is no pokemon with the id:"+ pokemonInfoId));
    }
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes an item with a specific id.")
    public Map<String, Boolean> deletePokemonStrategy(@ApiParam(value = "Delete an row with a specific id.") @PathVariable Integer id) throws Exception {
        PokemonInfoModel pokemonInfoModel = service.findById(id).orElseThrow(() -> new ResourceNotfoundException("There is no pokemon with the id:"+ id));
        service.delete(pokemonInfoModel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", true);
        return response;
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
