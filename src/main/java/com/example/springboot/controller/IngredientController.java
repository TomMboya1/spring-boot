package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import com.example.springboot.service.IngredientService;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientController {
    private IngredientService ingredientService;
    private MealService mealService;
    private List<Meal> meals = new ArrayList<>();

    @Autowired
    public IngredientController(IngredientService ingredientService, MealService mealService) {
        this.ingredientService = ingredientService;
        this.mealService = mealService;
    }

    @PutMapping("/add-ingredient")
    public ResponseEntity<Meal> addMeal() {

        return ResponseEntity.ok().build();
    }
    @PostMapping("/meal")
    public void addMeal(@RequestBody Meal meal) {
        meals.add(meal);
    }

    @PutMapping("/meal/{name}")
    public void updateMeal(@PathVariable String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : meals) {
            if (meal.getName().equals(name)) {
                meal.setName(updatedMeal.getName());
                meal.setDescription(updatedMeal.getDescription());
                meal.setPrice(updatedMeal.getPrice());
                break;
            }
        }
    }

    @DeleteMapping("/meal/{name}")
    public void deleteMeal(@PathVariable String name) {
        meals.removeIf(meal -> meal.getName().equals(name));
    }
    @DeleteMapping("/meal/price/{price}")
    public void deleteMealsAbovePrice(@PathVariable double price) {
        meals.removeIf(meal -> meal.getPrice() > price);
    }

}
