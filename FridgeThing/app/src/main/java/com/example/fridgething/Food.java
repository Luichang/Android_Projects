package com.example.fridgething;

import java.util.Date;
import java.util.Vector;

public class Food {

    public static class Builder { // using a builder removes the need to implement a lot of redundant constructors
        String name; // we can't have food without a name so it will be passed in the constructor
        int quantity;
        String quantityType; // since this should not be changed this will be set in the constructor as well
        Date purchaseDate;
        Date expirationDate;
        String category;

        public Builder(String name, String quantityType) {
            this.name = name;
            this.quantityType = quantityType;
            this.purchaseDate = new Date();
        }

        public Builder amount(int quantity) {
            this.quantity = quantity;

            return this; // by returning this we can have a single line of calls
        }


        public Builder expires(Date expirationDate) {
            this.expirationDate = expirationDate;

            return  this;
        }

        public Builder isA(String category) {
            this.category = category;

            return this;
        }

        public Food build() {
            Food food = new Food(); // the constructor is private and has no parameters so we create an empty object
            // we proceed to set the given information

            // the question now remains if builder functions left out will yield usable Food items

            food.name = this.name;
            food.quantity = this.quantity;
            food.quantityType = this.quantityType;
            food.purchaseDate = this.purchaseDate;
            food.expirationDate = this.expirationDate;
            food.category = this.category;


            return food;
        }



    }

    private String name;
    private int quantity;
    private String quantityType;
    private Date purchaseDate;
    private Date expirationDate;
    private String category;
    private Vector Recipies;


    private Food() {

    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Vector getRecipies() {
        return Recipies;
    }

    public void addRecipie(String recipe) {
        this.Recipies.add(recipe);
    }

    public void removeRecipie(String recipe) {
        int removeIndex = this.Recipies.indexOf(recipe);
        if (removeIndex > -1) {
            this.Recipies.remove(removeIndex);
        }
    }

}
