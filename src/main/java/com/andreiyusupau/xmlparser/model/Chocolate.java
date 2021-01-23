package com.andreiyusupau.xmlparser.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Chocolate")
public class Chocolate extends Candy {
    @XmlElement(name = "Chocolate")
    private int cocoa;
    @XmlPath("Chocolate/@type")
    private ChocolateType chocolateType;
    @XmlElement(name = "Nuts")
    private int nuts;
    @XmlPath("Nuts/@type")
    private String nutsType;

    public Chocolate() {
    }

    public Chocolate(long id, String name, int energy, int water, boolean preparedWater, int sugar, String sugarType, double proteins, double fats, double carbohydrates, String production, String country, int cocoa, ChocolateType chocolateType, int nuts, String nutsType) {
        super(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country);
        this.cocoa = cocoa;
        this.chocolateType = chocolateType;
        this.nuts = nuts;
        this.nutsType = nutsType;
    }

    public enum ChocolateType{
        DARK, MILK, WHITE
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "cocoa=" + cocoa +
                ", chocolateType=" + chocolateType +
                ", nuts=" + nuts +
                ", nutsType='" + nutsType + '\'' +
                "} " + super.toString();
    }
}
