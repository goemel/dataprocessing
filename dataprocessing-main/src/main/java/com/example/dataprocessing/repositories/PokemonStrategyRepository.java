package com.example.dataprocessing.repositories;

import com.example.dataprocessing.models.PokemonStrategyModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonStrategyRepository extends CrudRepository<PokemonStrategyModel, Integer>{
}
