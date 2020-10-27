package com.andreiyusupau.xmlparser.model;

import javax.xml.bind.annotation.XmlAttribute;
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
    @XmlElement(name = "Water")
    private int water;
    @XmlAttribute(name = "prepared")
    private boolean preparedWater;
    @XmlElement(name = "Sugar")
    private int sugar;
    @XmlAttribute(name = "type")
    private String sugarType;
    @XmlElement(name = "Proteins")
    private double proteins;
    @XmlElement(name = "Fats")
    private double fats;
    @XmlElement(name = "Carbohydrates")
    private double carbohydrates;
    @XmlElement(name = "Production")
    private String production;
    @XmlAttribute(name = "country")
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
