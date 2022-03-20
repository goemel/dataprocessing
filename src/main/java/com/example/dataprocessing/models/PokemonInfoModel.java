package com.example.dataprocessing.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemoninfo")
public class PokemonInfoModel {

    @Id
    private Integer id;
    private int pokedexNumber;
    private String name;
    private String Classification;
    private String alternateForm;
    private int Orignal;
    private String Legendary;
    private double height;
    private double weight;
    private String primaryType;

    public PokemonInfoModel(Integer id, int pokedexNumber, String name, String classification, String alternateForm, int orignal, String legendary, double height, double weight, String primaryType) {
        this.id = id;
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        Classification = classification;
        this.alternateForm = alternateForm;
        Orignal = orignal;
        Legendary = legendary;
        this.height = height;
        this.weight = weight;
        this.primaryType = primaryType;
    }

    public PokemonInfoModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
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

    public int getOrignal() {
        return Orignal;
    }

    public void setOrignal(int orignal) {
        Orignal = orignal;
    }

    public String getLegendary() {
        return Legendary;
    }

    public void setLegendary(String legendary) {
        Legendary = legendary;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }
}
