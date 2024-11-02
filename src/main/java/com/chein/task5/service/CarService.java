package com.chein.task5.service;

import com.chein.task5.exceptions.DateException;
import com.chein.task5.model.car.Car;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.regex.Pattern;

public class CarService {
    private static final Pattern DATE_PATTER =
            Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");
    private static final int MAX_DELIVERY = 40;

    public void setDispatchDate(Car car, String date){
        isDataValid(date);
        car.setDispatchDate(LocalDate.parse(date));
    }
    public void setDeliveryDays(Car car, String monthDay1, String monthDay2){
        isDeliveryDateValid(monthDay1, monthDay2);
        car.setDeliveryDays(MonthDay.parse(monthDay1));
    }

    private void isDataValid(String date){
        if (!DATE_PATTER.matcher(date).matches()){
            throw new DateException("Формат даты: YYYY-MM-DD");
        }
    }

    private String isDeliveryDateValid(String monthDay1 , String monthDay2){
        int compare = monthDay2.compareTo(monthDay1);
        if (compare != 0){
            throw new DateException("Нас не устраивает дата поставки");
        }
        else{
            return monthDay1;
        }
    }



}