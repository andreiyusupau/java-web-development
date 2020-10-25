package com.andreiyusupau.xmlparser.model;

public abstract class Candy {

    private long id;
    private String name;
    private int energy;
    private int water;
    private boolean preparedWater;
    private int sugar;
    private String sugarType;
    private double proteins;
    private double fats;
    private double carbohydrates;
    private String production;
    private String country;

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
}
