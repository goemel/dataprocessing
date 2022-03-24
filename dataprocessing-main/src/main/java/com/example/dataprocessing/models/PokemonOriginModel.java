package com.example.dataprocessing.models;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemonorigin")
public class PokemonOriginModel {

    @Id
    @Column(name="Index")
    @ApiModelProperty(notes = "The index number of the pokemon", dataType = "Integer")
    private Integer Index;
    @Column(name="PokedexNumber")
    @ApiModelProperty(notes = "The pokedex number of the pokemon", dataType = "Integer")
    private Integer pokedex_number;
    @Column(name="PokemonName")
    @ApiModelProperty(notes = "The name of the pokemon", dataType = "String")
    private String name;
    @Column(name="GermanName")
    @ApiModelProperty(notes = "The pokemonname translated in german", dataType = "String")
    private String german_name;
    @Column(name="JapaneseName")
    @ApiModelProperty(notes = "The pokemonname translated in japanese", dataType = "String")
    private String japanese_name;
    @Column(name="Generation")
    @ApiModelProperty(notes = "The generation the pokemon was created", dataType = "Integer")
    private Integer generation;
    @Column(name="IsSubLegendary")
    @ApiModelProperty(notes = "To see if the pokemon is sub legendary", dataType = "Integer")
    private Integer is_sub_legendary;
    @Column(name="IsLegendary")
    @ApiModelProperty(notes = "To see if the pokemon is legendary", dataType = "Integer")
    private Integer is_legendary;
    @Column(name="IsMythical")
    @ApiModelProperty(notes = "To see if the pokemon is mythical", dataType = "Integer")
    private Integer is_mythical;
    @Column(name="Species")
    @ApiModelProperty(notes = "The species the pokemon is", dataType = "String")
    private String species;


    public Integer getIndex() {
        return Index;
    }

    public void setIndex(Integer index) {
        this.Index = index;
    }

    public Integer getPokedex_number() {
        return pokedex_number;
    }

    public void setPokedex_number(Integer pokedex_number) {
        this.pokedex_number = pokedex_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGerman_name() {
        return german_name;
    }

    public void setGerman_name(String german_name) {
        this.german_name = german_name;
    }

    public String getJapanese_name() {
        return japanese_name;
    }

    public void setJapanese_name(String japanese_name) {
        this.japanese_name = japanese_name;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public Integer getIs_sub_legendary() {
        return is_sub_legendary;
    }

    public void setIs_sub_legendary(Integer is_sub_legendary) {
        this.is_sub_legendary = is_sub_legendary;
    }

    public Integer getIs_legendary() {
        return is_legendary;
    }

    public void setIs_legendary(Integer is_legendary) {
        this.is_legendary = is_legendary;
    }

    public Integer getIs_mythical() {
        return is_mythical;
    }

    public void setIs_mythical(Integer is_mythical) {
        this.is_mythical = is_mythical;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
