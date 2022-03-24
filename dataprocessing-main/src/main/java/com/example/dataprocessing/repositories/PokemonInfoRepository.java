package com.example.dataprocessing.repositories;

import com.example.dataprocessing.models.PokemonInfoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonInfoRepository extends CrudRepository<PokemonInfoModel, Integer>{
}
