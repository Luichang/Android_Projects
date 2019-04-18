package com.example.fridgething;

import java.util.Vector;

public class Storage {
    String name;
    Vector<Food> foods;

    public Storage(String name) {
        this.name = name;
    }

    public void store(Food food){
        foods.add(food);
    }

    public void retrieve(Food food) {
        int removeIndex = this.foods.indexOf(food);
        if (removeIndex > -1) {
            this.foods.remove(removeIndex);
            food.setQuantity(0);
        }

    }

    public void retrieve(Food food, int amount) {
        int removeIndex = this.foods.indexOf(food);
        if (removeIndex > -1) {
            this.foods.remove(removeIndex);
            food.setQuantity(food.getQuantity() - amount);
        }
    }
}
