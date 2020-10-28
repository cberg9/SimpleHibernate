package com.company.demo.Models;

import javax.persistence.*;

@Entity
public class Candy {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;
    @Column (nullable = false)
    private String name;
    @Column
    private String type;
    @Column
    private double weightPerUnit;
    @Column
    private double costPerUnit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeightPerUnit() {
        return weightPerUnit;
    }

    public void setWeightPerUnit(double weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }
}
