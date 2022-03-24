package com.example.dataprocessing.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemonorigin")
public class PokemonOriginModel {

    @Id
    @Column(name="Index")
    private Integer Index;
    @Column(name="PokedexNumber")
    private Integer pokedex_number;
    @Column(name="PokemonName")
    private String name;
    @Column(name="GermanName")
    private String german_name;
    @Column(name="JapaneseName")
    private String japanese_name;
    @Column(name="Generation")
    private Integer generation;
    @Column(name="IsSubLegendary")
    private Integer is_sub_legendary;
    @Column(name="IsLegendary")
    private Integer is_legendary;
    @Column(name="IsMythical")
    private Integer is_mythical;
    @Column(name="Species")
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
