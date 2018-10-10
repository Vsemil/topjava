package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MealServiceImpl implements MealService {

    private List<Meal> meals = Arrays.asList(
            new Meal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new Meal(2, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new Meal(3, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new Meal(4, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new Meal(5, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new Meal(6, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
    );
    private volatile long incId = meals.size();
    @Override
    public Meal add(Meal meal) {
        if (meal == null) {
            return null;
        }
        incId = incId + 1;
        meal.setId(incId);
        meals.add(meal);
        return meal;
    }

    @Override
    public List<Meal> getAll() {
        return meals;
    }

    @Override
    public Meal get(long mealId) {
        for (Meal meal: meals){
            if (mealId == meal.getId())
                return meal;
        }
        return null;
    }

    @Override
    public Meal update(Meal meal) {
        if (meal == null) {
            return null;
        }
        Meal mealTemp = null;
        for (Meal m: meals){
            if (meal.getId() == m.getId()) {
                mealTemp = m;
                break;
            }
        }

        if (mealTemp != null) {
            meals.remove(mealTemp);
        }
        meals.add(meal);

        return meal;
    }

    @Override
    public void delete(Meal meal) {
        meals.remove(meal);
    }

    @Override
    public void delete(long mealId) {
        Meal mealTemp = null;
        for (Meal m: meals){
            if (mealId == m.getId()) {
                mealTemp = m;
                break;
            }
        }
        if (mealTemp != null) {
            meals.remove(mealTemp);
        }
    }
}
