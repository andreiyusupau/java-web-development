package com.andreiyusupau.xmlparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hard-candy")
public class HardCandy extends Candy{
    @XmlElement(name = "Citric-acid")
    private int citricAcid;

    public HardCandy() {
    }

    public HardCandy(long id, String name, int energy, int water, boolean preparedWater, int sugar, String sugarType, double proteins, double fats, double carbohydrates, String production, String country, int citricAcid) {
        super(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country);
        this.citricAcid = citricAcid;
    }

    @Override
    public String toString() {
        return "HardCandy{" +
                "citricAcid=" + citricAcid +
                "} " + super.toString();
    }
}
