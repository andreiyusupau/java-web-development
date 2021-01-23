package com.andreiyusupau.xmlparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Liquorice")
public class Liquorice extends Candy{
    @XmlElement(name = "Liquorice-extract")
    private int liquoriceExtract;
    @XmlElement(name = "Starch")
    private int starch;

    public Liquorice() {
    }

    public Liquorice(long id, String name, int energy, int water, boolean preparedWater, int sugar, String sugarType, double proteins, double fats, double carbohydrates, String production, String country, int liquoriceExtract, int starch) {
        super(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country);
        this.liquoriceExtract = liquoriceExtract;
        this.starch = starch;
    }

    @Override
    public String toString() {
        return "Liquorice{" +
                "liquoriceExtract=" + liquoriceExtract +
                ", starch=" + starch +
                "} " + super.toString();
    }
}
