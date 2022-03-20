package com.example.dataprocessing.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemonorigin")
public class PokemonOriginModel {

    @Id
    private Integer Index;
    private int pokedex_number;
    private String name;
    private String german_name;
    private String japanese_name;
    private int generation;
    private int is_sub_legendary;
    private int is_legendary;
    private int is_mythical;
    private String species;

    public PokemonOriginModel(Integer index, int pokedex_number, String name, String german_name, String japanese_name, int generation, int is_sub_legendary, int is_legendary, int is_mythical, String species) {
        this.Index = index;
        this.pokedex_number = pokedex_number;
        this.name = name;
        this.german_name = german_name;
        this.japanese_name = japanese_name;
        this.generation = generation;
        this.is_sub_legendary = is_sub_legendary;
        this.is_legendary = is_legendary;
        this.is_mythical = is_mythical;
        this.species = species;
    }

    public PokemonOriginModel() {

    }

    public Integer getIndex() {
        return Index;
    }

    public void setIndex(Integer index) {
        this.Index = index;
    }

    public int getPokedex_number() {
        return pokedex_number;
    }

    public void setPokedex_number(int pokedex_number) {
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

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getIs_sub_legendary() {
        return is_sub_legendary;
    }

    public void setIs_sub_legendary(int is_sub_legendary) {
        this.is_sub_legendary = is_sub_legendary;
    }

    public int getIs_legendary() {
        return is_legendary;
    }

    public void setIs_legendary(int is_legendary) {
        this.is_legendary = is_legendary;
    }

    public int getIs_mythical() {
        return is_mythical;
    }

    public void setIs_mythical(int is_mythical) {
        this.is_mythical = is_mythical;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
