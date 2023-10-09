package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    private List<Meal> meals = new ArrayList<>();
    private MealService mealService;
    private Meal meal;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

//    @PutMapping("/meal")
//    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
//        mealService.addMeal(meal);
//        return ResponseEntity.ok(meal);
//    }

    @DeleteMapping("/meal/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/meal")
//    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal) {
//        mealService.updateMeal(meal);
//        return ResponseEntity.ok(meal);
//    }

    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals() {
        return ResponseEntity.ok(mealService.getSummerMeals());
    }

    @GetMapping("/secret-formula")
    public ResponseEntity<String> getSecretFormula() {
        return ResponseEntity.ok("2 + 2 = 4");
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

    @PutMapping("/meal/{name}/price")
    public void updateMealPrice(@PathVariable String name, @RequestBody double updatedPrice) {
        for (Meal meal : meals) {
            if (meal.getName().equals(name)) {
                meal.setPrice(updatedPrice);
                break;
            }
        }
    }

}
