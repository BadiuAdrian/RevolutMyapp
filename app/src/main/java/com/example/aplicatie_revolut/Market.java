package com.example.aplicatie_revolut;

public class Market {

    int price;

    GroceriesType groceries;

    public Market(GroceriesType groceries, int price){
        this.groceries= groceries;
        this.price= price;
    }

    public GroceriesType getGroceries() {
        return groceries;
    }

    public int getPrice() {
        return price;
    }
}
