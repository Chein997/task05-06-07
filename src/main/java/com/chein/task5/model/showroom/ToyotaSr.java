package com.chein.task5.model.showroom;

import com.chein.task5.model.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ToyotaSr extends Showroom{
    private List<Car> carList = new ArrayList<>();

    @Override
    public ShowroomBrand getBrand() {
        return ShowroomBrand.TOYOTA_SHOWROOM;
    }

    @Override
    public void bringCar(Car car) {
        super.log("Загоняем машину в салон тойота");
        this.carList.add(car);
    }

    @Override
    public List<Car> getCars() {
        return this.carList;
    }

    @Override
    public void clearShowroom() {
        this.carList =  new ArrayList<>();
    }
}
