package com.example.dataprocessing.controllers;

import com.example.dataprocessing.models.PokemonInfoModel;
import com.example.dataprocessing.repositories.PokemonInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@RequestMapping("/pokemonInfos")
public class PokemonInfoController {
    @Autowired
    private PokemonInfoRepository service;

    @CrossOrigin
    @GetMapping
    public Iterable<PokemonInfoModel> findAllPokemons() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<PokemonInfoModel> findPokemonById(@PathVariable(value = "id") Integer id) {
        Optional<PokemonInfoModel> Pokemon = service.findById(id);

        return Pokemon.map(pokemonStrategyModel -> ResponseEntity.ok().body(pokemonStrategyModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonInfoModel create(@Valid @RequestBody PokemonInfoModel pokemonInfoModel) {
        return service.save(pokemonInfoModel);
    }@PutMapping("/{id}")
    public PokemonInfoModel replacePokemonStragtegy(@RequestBody PokemonInfoModel pokemonInfoModel, @PathVariable Integer id) {
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
