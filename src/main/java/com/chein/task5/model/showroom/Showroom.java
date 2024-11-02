package com.chein.task5.model.showroom;

import com.chein.task5.model.car.Car;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class Showroom {
    public abstract ShowroomBrand getBrand();
    public abstract List<Car> getCars();
    public abstract void bringCar(Car car);
    public abstract void clearShowroom();
    public void log(String mess) {
        log.info(mess);
    }


}
