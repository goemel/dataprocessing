package com.example.dataprocessing.controllers;

import com.example.dataprocessing.exceptions.ResourceNotfoundException;
import com.example.dataprocessing.models.PokemonInfoModel;
import com.example.dataprocessing.models.PokemonOriginModel;
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
@RequestMapping(value = "/pokemonStrategys",  produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.ALL_VALUE)
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
    public PokemonStrategyModel replacePokemonStragtegy(@RequestBody @ApiParam(value = "Id of the pokemon that you want to update") @PathVariable(value = "id") int pokemonStrategyId, @Valid @RequestBody PokemonStrategyModel pokemonStrategyModelDetails) throws ResourceNotfoundException {
        return service.findById(pokemonStrategyId)
                .map(pokemon -> {
                    pokemon.setId(pokemonStrategyModelDetails.getId());
                    pokemon.setName(pokemonStrategyModelDetails.getName());
                    pokemon.setType1(pokemonStrategyModelDetails.getType1());
                    pokemon.setType2(pokemonStrategyModelDetails.getType2());
                    pokemon.setTotal(pokemonStrategyModelDetails.getTotal());
                    pokemon.setHP(pokemonStrategyModelDetails.getHP());
                    pokemon.setAttack(pokemonStrategyModelDetails.getAttack());
                    pokemon.setDefense(pokemonStrategyModelDetails.getDefense());
                    pokemon.setSpAttack(pokemonStrategyModelDetails.getSpAttack());
                    pokemon.setSpDefense(pokemonStrategyModelDetails.getSpDefense());
                    return service.save(pokemon);
                })
                .orElseThrow(() -> new ResourceNotfoundException("There is no pokemon with the id:"+ pokemonStrategyId));
    }
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes an item with a specific id.")
    public Map<String, Boolean> deletePokemonStrategy(@PathVariable @ApiParam(value = "Update pokemon with the id") Integer id) throws Exception {
        PokemonStrategyModel pokemonStrategyModel = service.findById(id).orElseThrow(() -> new ResourceNotfoundException("There is no pokemon with the id:"+ id));
        service.delete(pokemonStrategyModel);
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
