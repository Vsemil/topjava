package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealService {
    Meal add(Meal meal);
    List<Meal> getAll();
    Meal get(long mealId);
    Meal update(Meal meal);
    void delete(Meal meal);
    void delete(long mealId);
}
