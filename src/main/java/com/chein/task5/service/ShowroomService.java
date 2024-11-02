package com.chein.task5.service;

import com.chein.task5.exceptions.LocationException;
import com.chein.task5.model.car.Car;
import com.chein.task5.model.car.CarBrand;
import com.chein.task5.model.showroom.Showroom;
import com.chein.task5.model.showroom.ShowroomBrand;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class ShowroomService {
    private static Map<String, Showroom> showrooms =  new HashMap<>();;
    private static final String ERROR_MESSAGE = "не в тот салон поставили";

    public ShowroomService(Map<String, Showroom> showrooms) {
        this.showrooms = showrooms;
    }

    public void bringCarToShowroom(Car car, Showroom showroom) {
        try {
            isRightShowroom(car.getBrand(), showroom.getBrand());
            showroom.bringCar(car);
        } catch (LocationException e) {
            log.error(ERROR_MESSAGE.formatted(e.getMessage()));
        } finally {
            if (showrooms.get(car.getBrand().toValue()).getCars().isEmpty()){
                showrooms.get(car.getBrand().toValue())
                        .bringCar(car);
                log.info("машину загнали");
            }
        }
    }


    private void isRightShowroom(CarBrand carBrand, ShowroomBrand showroomBrand) {
        if (!carBrand.toValue().equals(showroomBrand.toValue())) {
            throw new LocationException("ne tuda postavili");
        }
    }
}
