package com.andreiyusupau.xmlparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Toffee")
public class Toffee extends Candy {
    @XmlElement(name = "Butter")
    private int butter;
    @XmlElement(name = "Flour")
    private int flour;

    public Toffee() {
    }

    public Toffee(long id, String name, int energy, int water, boolean preparedWater, int sugar, String sugarType, double proteins, double fats, double carbohydrates, String production, String country, int butter, int flour) {
        super(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country);
        this.butter = butter;
        this.flour = flour;
    }

    @Override
    public String toString() {
        return "Toffee{" +
                "butter=" + butter +
                ", flour=" + flour +
                "} " + super.toString();
    }
}
