package com.example.dataprocessing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemoninfo")
public class PokemonInfoModel {

    @Id
    @Column(name="PokemonId")
    private Integer id;
    @Column(name="PokedexNumber")
    private Integer pokedexNumber;
    @Column(name="PokemonName")
    private String name;
    @Column(name="Classification")
    private String Classification;
    @Column(name="AlternateFormName")
    private String alternateForm;
    @Column(name="OriginalPokemonID")
    private Integer Orignal;
    @Column(name="LegendaryType")
    private String Legendary;
    @Column(name="PokemonHeight")
    private Double height;
    @Column(name="PokemonWeight")
    private Double weight;
    @Column(name="PrimaryType")
    private String primaryType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(Integer pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String classification) {
        Classification = classification;
    }

    public String getAlternateForm() {
        return alternateForm;
    }

    public void setAlternateForm(String alternateForm) {
        this.alternateForm = alternateForm;
    }

    public Integer getOrignal() {
        return Orignal;
    }

    public void setOrignal(Integer orignal) {
        Orignal = orignal;
    }

    public String getLegendary() {
        return Legendary;
    }

    public void setLegendary(String legendary) {
        Legendary = legendary;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }
}
