package com.example.dataprocessing.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemoninfo")
public class PokemonInfoModel {

    @Id
    @Column(name="PokemonId")
    @ApiModelProperty(notes = "The id of the pokemon", dataType = "Integer")
    private Integer id;
    @Column(name="PokedexNumber")
    @ApiModelProperty(notes = "The pokedexnumber of the pokemon", dataType = "Integer")
    private Integer pokedexNumber;
    @Column(name="PokemonName")
    @ApiModelProperty(notes = "The name of the pokemon", dataType = "String")
    private String name;
    @Column(name="Classification")
    @ApiModelProperty(notes = "The classifacation of the pokemon", dataType = "String")
    private String Classification;
    @Column(name="AlternateFormName")
    @ApiModelProperty(notes = "The alternate form type of the pokemon", dataType = "String")
    private String alternateForm;
    @Column(name="OriginalPokemonID")
    @ApiModelProperty(notes = "The original pokemon id", dataType = "Integer")
    private Integer Orignal;
    @Column(name="LegendaryType")
    @ApiModelProperty(notes = "If the pokemon is legendary", dataType = "String")
    private String Legendary;
    @Column(name="PokemonHeight")
    @ApiModelProperty(notes = "The height of the pokemon", dataType = "Double")
    private Double height;
    @Column(name="PokemonWeight")
    @ApiModelProperty(notes = "The weight of the pokemon", dataType = "Double")
    private Double weight;
    @Column(name="PrimaryType")
    @ApiModelProperty(notes = "The primary type of the pokemon", dataType = "String")
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
