package ru.javawebinar.topjava.repository.mock;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        // treat case: update, but absent in storage
        return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Meal> getAll() {
        List<Meal> meals = new ArrayList<>(repository.values());
        meals.sort(Comparator.comparing(Meal::getDateTime).reversed());
        return meals;
    }

    @Override
    public List<Meal> getAllByUserId(int userId) {
        List<Meal> meals = new ArrayList<>();
        repository.forEach((id, meal) -> {
            if (userId == meal.getUserId()) {
                meals.add(meal);
            }
        });
        meals.sort(Comparator.comparing(Meal::getDateTime).reversed());
        return meals.isEmpty()? null: meals;
    }
}

