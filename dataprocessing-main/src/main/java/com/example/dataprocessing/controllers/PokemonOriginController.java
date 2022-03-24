package com.example.dataprocessing.controllers;

import com.example.dataprocessing.models.PokemonOriginModel;
import com.example.dataprocessing.repositories.PokemonOriginRepository;
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
@RequestMapping("/pokemonOrigins")
public class PokemonOriginController {
    @Autowired
    private PokemonOriginRepository service;

    @GetMapping
    public Iterable<PokemonOriginModel> findAllPokemons() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<PokemonOriginModel> findPokemonById(@PathVariable(value = "index") Integer id) {
        Optional<PokemonOriginModel> Pokemon = service.findById(id);

        return Pokemon.map(pokemonOriginModel -> ResponseEntity.ok().body(pokemonOriginModel)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonOriginModel create(@Valid @RequestBody PokemonOriginModel pokemonOriginModel) {
        return service.save(pokemonOriginModel);
    }@PutMapping("/{id}")
    public PokemonOriginModel replacePokemonOrigin(@RequestBody PokemonOriginModel pokemonOriginModel, @PathVariable Integer id) {
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
    void deletePokemonOrigin(@PathVariable Integer id) {
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
