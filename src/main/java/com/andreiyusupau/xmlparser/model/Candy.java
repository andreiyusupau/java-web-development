package com.andreiyusupau.xmlparser.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
@XmlSeeAlso({Chocolate.class, HardCandy.class, Liquorice.class,Marshmallow.class,Toffee.class})
public abstract class Candy {
    @XmlElement
    private long id;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Energy")
    private int energy;
    @XmlPath("Ingredients/Water")
    private int water;
    @XmlPath("Ingredients/Water/@prepared")
    private boolean preparedWater;
    @XmlPath("Ingredients/Sugar")
    private int sugar;
    @XmlPath("Ingredients/Sugar/@type")
    private String sugarType;
    @XmlPath("Value/Protein")
    private double proteins;
    @XmlPath("Value/Fats")
    private double fats;
    @XmlPath("Value/Carbohydrates")
    private double carbohydrates;
    @XmlElement(name = "Production")
    private String production;
    @XmlPath("Production/@country")
    private String country;

    public Candy() {
    }

    public Candy(long id, String name, int energy, int water, boolean preparedWater, int sugar, String sugarType, double proteins, double fats, double carbohydrates, String production, String country) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.water = water;
        this.preparedWater = preparedWater;
        this.sugar = sugar;
        this.sugarType = sugarType;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.production = production;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", water=" + water +
                ", preparedWater=" + preparedWater +
                ", sugar=" + sugar +
                ", sugarType='" + sugarType + '\'' +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", production='" + production + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
