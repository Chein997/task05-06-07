package com.chein.task6.comporator;

import com.chein.task6.model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2){
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
