package com.example.dataprocessing.models;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemonstrategy")
public class PokemonStrategyModel {

    @Id
    @Column(name="pokedexnumber")
    @ApiModelProperty(notes = "The id of the pokemon", dataType = "Integer")
    private Integer id;
    @Column(name="name")
    @ApiModelProperty(notes = "The name of the pokemon", dataType = "String")
    private String Name;
    @Column(name="primarytype")
    @ApiModelProperty(notes = "The primary type of the pokemon", dataType = "String")
    private String Type1;
    @Column(name="secondarytype")
    @ApiModelProperty(notes = "The secondary type of the pokemon", dataType = "String")
    private String Type2;
    @Column(name="sumstats")
    @ApiModelProperty(notes = "The sum of the pokemon stats", dataType = "Integer")
    private Integer Total;
    @Column(name="hp")
    @ApiModelProperty(notes = "The hp of the pokemon", dataType = "Integer")
    private Integer HP;
    @Column(name="attack")
    @ApiModelProperty(notes = "The attack stat of the pokemon", dataType = "Integer")
    private Integer Attack;
    @Column(name="defense")
    @ApiModelProperty(notes = "The defense stat of the pokemon", dataType = "Integer")
    private Integer Defense;
    @Column(name="spattack")
    @ApiModelProperty(notes = "The special attack stat of the pokemon", dataType = "Integer")
    private Integer SpAttack;
    @Column(name="spdefense")
    @ApiModelProperty(notes = "The special defense stat of the pokemon", dataType = "Integer")
    private Integer SpDefense;

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

    public Integer getTotal() {
        return this.Total;
    }

    public void setTotal(Integer total) {
        this.Total = total;
    }

    public Integer getHP() {
        return this.HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Integer getAttack() {
        return this.Attack;
    }

    public void setAttack(Integer attack) {
        this.Attack = attack;
    }

    public Integer getDefense() {
        return this.Defense;
    }

    public void setDefense(Integer defense) {
        this.Defense = defense;
    }

    public Integer getSpAttack() {
        return this.SpAttack;
    }

    public void setSpAttack(Integer spAttack) {
        this.SpAttack = spAttack;
    }

    public Integer getSpDefense() {
        return this.SpDefense;
    }

    public void setSpDefense(Integer spDefense) {
        this.SpDefense = spDefense;
    }
}
