package com.example.dataprocessing.controllers;

import com.example.dataprocessing.models.PokemonStrategyModel;
import com.example.dataprocessing.repositories.PokemonStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/pokemonStrategys")
public class PokemonStrategyController {
    @Autowired
    private PokemonStrategyRepository service;

    @CrossOrigin
    @GetMapping
    public Iterable<PokemonStrategyModel> findAllPokemons() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<PokemonStrategyModel> findPokemonById(@PathVariable(value = "id") Integer id) {
        Optional<PokemonStrategyModel> Pokemon = service.findById(id);

        return Pokemon.map(pokemonStrategyModel -> ResponseEntity.ok().body(pokemonStrategyModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonStrategyModel create(@Valid @RequestBody PokemonStrategyModel pokemonStrategyModel) {
        return service.save(pokemonStrategyModel);
    }@PutMapping("/{id}")
    public PokemonStrategyModel replacePokemonStragtegy(@RequestBody PokemonStrategyModel pokemonStrategyModel, @PathVariable Integer id) {
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
    void deletePokemonStrategy(@PathVariable Integer id) {
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
