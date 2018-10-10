package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealService mealService = new MealServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("!!!!!");
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mealIdStr = request.getParameter("mealId");
        if (mealIdStr != null && !mealIdStr.isEmpty()) {
            long mealId = Long.parseLong(mealIdStr);
            Meal meal = mealService.get(mealId);
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("/editMeal.jsp").forward(request, response);
        } else {
            request.setAttribute("meals", MealsUtil.getFilteredWithExceeded(mealService.getAll(), LocalTime.of(0, 0), LocalTime.of(23, 0), 2000));
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
