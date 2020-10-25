package com.andreiyusupau.xmlparser.model;

public class Chocolate extends Candy {
    private int cocoa;
    private ChocolateType chocolateType;
    private int nuts;
    private String nutsType;

    public Chocolate(long id, String name, int energy, boolean preparedWater, int sugar, String sugarType, double proteins, double fats, double carbohydrates, String production, String country, int cocoa, ChocolateType chocolateType, int nuts, String nutsType) {
        super(id, name, energy, water, preparedWater, sugar, sugarType, proteins, fats, carbohydrates, production, country);
        this.cocoa = cocoa;
        this.chocolateType = chocolateType;
        this.nuts = nuts;
        this.nutsType = nutsType;
    }

    private enum ChocolateType{
        DARK, MILK, WHITE
    }
}
