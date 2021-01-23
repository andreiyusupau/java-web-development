package com.andreiyusupau.xmlparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Marshmallow")
public class Marshmallow extends Candy{
    @XmlElement(name = "Gelatin")
    private int gelatin;

    public Marshmallow() {
    }

    public Marshmallow(long id, String name, int energy, int water, boolean preparedWater, int sugar, String sugarType, double proteins, double fats, double carbohydrates, String production, String country, int gelatin) {
        super(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country);
        this.gelatin = gelatin;
    }

    @Override
    public String toString() {
        return "Marshmallow{" +
                "gelatin=" + gelatin +
                "} " + super.toString();
    }
}
