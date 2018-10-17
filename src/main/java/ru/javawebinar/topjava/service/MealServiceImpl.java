package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;


    @Override
    public Meal create(Meal meal, int userId) {
        meal.setUserId(userId);
        return repository.save(meal);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        Meal meal = repository.get(id);
        if (meal != null && meal.getUserId() == userId) {
            checkNotFoundWithId(repository.delete(id), id);
        } else {
            throw new NotFoundException("");
        }
    }

    @Override
    public Meal get(int id, int userId) throws NotFoundException {
        Meal meal = checkNotFoundWithId(repository.get(id), id);
        if (meal.getUserId() == userId) {
            return meal;
        } else {
            throw new NotFoundException("");
        }
    }

    @Override
    public void update(Meal meal, int userId) {
        checkNotFoundWithId(repository.save(meal), meal.getId());
    }

    @Override
    public List<Meal> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Meal> getAllByUserId(int userId) {
        return repository.getAllByUserId(userId);
    }
}