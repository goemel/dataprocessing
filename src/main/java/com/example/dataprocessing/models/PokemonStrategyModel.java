package com.example.dataprocessing.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemonstrategy")
public class PokemonStrategyModel {

    @Id
    private Integer id;
    private String Name;
    private String Type1;
    private String Type2;
    private int Total;
    private int Attack;
    private int Defense;
    private int SpAttack;
    private int SpDefense;
    private int Speed;
    private int Generation;
    private boolean Legendary;

    public PokemonStrategyModel(Integer id, String name, String type1, String type2, int total, int attack, int defense, int spAttack, int spDefense, int speed, int generation, boolean legendary) {
        this.id = id;
        this.Name = name;
        this.Type1 = type1;
        this.Type2 = type2;
        this.Total = total;
        this.Attack = attack;
        this.Defense = defense;
        this.SpAttack = spAttack;
        this.SpDefense = spDefense;
        this.Speed = speed;
        this.Generation = generation;
        this.Legendary = legendary;
    }

    public PokemonStrategyModel() {

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getType1() {
        return this.Type1;
    }

    public void setType1(String type1) {
        this.Type1 = type1;
    }

    public String getType2() {
        return this.Type2;
    }

    public void setType2(String type2) {
        this.Type2 = type2;
    }

    public int getTotal() {
        return this.Total;
    }

    public void setTotal(int total) {
        this.Total = total;
    }

    public int getAttack() {
        return this.Attack;
    }

    public void setAttack(int attack) {
        this.Attack = attack;
    }

    public int getDefense() {
        return this.Defense;
    }

    public void setDefense(int defense) {
        this.Defense = defense;
    }

    public int getSpAttack() {
        return this.SpAttack;
    }

    public void setSpAttack(int spAttack) {
        this.SpAttack = spAttack;
    }

    public int getSpDefense() {
        return this.SpDefense;
    }

    public void setSpDefense(int spDefense) {
        this.SpDefense = spDefense;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public void setSpeed(int speed) {
        this.Speed = speed;
    }

    public int getGeneration() {
        return this.Generation;
    }

    public void setGeneration(int generation) {
        this.Generation = generation;
    }

    public boolean getLegendary() {
        return this.Legendary;
    }

    public void setLegendary(boolean legendary) {
        this.Legendary = legendary;
    }
}
