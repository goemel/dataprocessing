package com.example.dataprocessing.controllers;

import com.example.dataprocessing.models.PokemonInfoModel;
import com.example.dataprocessing.models.PokemonStrategyModel;
import com.example.dataprocessing.repositories.PokemonStrategyRepository;
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
@RequestMapping(value="/pokemonStrategys", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class PokemonStrategyController {
    @Autowired
    private PokemonStrategyRepository service;

    @CrossOrigin
    @GetMapping
    @ApiOperation(
            value = "gets all object from the database",
            notes = "This is an select all.",
            response = List.class)
    public Iterable<PokemonStrategyModel> findAllPokemons() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ApiOperation(
            value = "gets the objects with the specific id from the database",
            notes = "This selects all the items with that id from the database.",
            response = PokemonInfoModel.class)
    public ResponseEntity<PokemonStrategyModel> findPokemonById(@ApiParam(value = "Update pokemon with the id") @PathVariable(value = "id") Integer id) {
        Optional<PokemonStrategyModel> Pokemon = service.findById(id);

        return Pokemon.map(pokemonStrategyModel -> ResponseEntity.ok().body(pokemonStrategyModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value = "Creates a new entry in the database.",
            response = PokemonInfoModel.class)
    public PokemonStrategyModel create(@Valid @RequestBody @ApiParam(value = "Update pokemon with the id") PokemonStrategyModel pokemonStrategyModel) {
        return service.save(pokemonStrategyModel);
    }@PutMapping("/{id}")
    @ApiOperation(
            value = "updatess the objects with the specific id from the database",
            notes = "This updates the row with the searched id.",
            response = PokemonInfoModel.class)
    public PokemonStrategyModel replacePokemonStragtegy(@RequestBody PokemonStrategyModel pokemonStrategyModel, @ApiParam(value = "Update pokemon with the id") @PathVariable Integer id) {
        return service.findById(id)
                .map(pokemon -> {
                    pokemon.setId(pokemonStrategyModel.getId());
                    pokemon.setName(pokemonStrategyModel.getName());
                    pokemon.setType1(pokemonStrategyModel.getType1());
                    pokemon.setType2(pokemonStrategyModel.getType2());
                    pokemon.setTotal(pokemonStrategyModel.getTotal());
                    pokemon.setHP(pokemonStrategyModel.getHP());
                    pokemon.setAttack(pokemonStrategyModel.getAttack());
                    pokemon.setDefense(pokemonStrategyModel.getDefense());
                    pokemon.setSpAttack(pokemonStrategyModel.getSpAttack());
                    pokemon.setSpDefense(pokemonStrategyModel.getSpDefense());
                    return service.save(pokemon);
                })
                .orElseGet(() -> {
                    pokemonStrategyModel.setId(id);
                    return service.save(pokemonStrategyModel);
                });
    }
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes an item with a specific id.")
    void deletePokemonStrategy(@PathVariable @ApiParam(value = "Update pokemon with the id") Integer id) {
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
