package com.example.dataprocessing.repositories;

import com.example.dataprocessing.models.PokemonOriginModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonOriginRepository extends CrudRepository<PokemonOriginModel, Integer>
{}