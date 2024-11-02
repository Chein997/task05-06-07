package com.chein.task5.test;

import com.chein.task5.model.car.Car;
import com.chein.task5.model.car.CarBrand;
import com.chein.task5.model.showroom.*;
import com.chein.task5.service.ShowroomService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowroomServiceTest {
    private static final Map<String, Showroom> showrooms = new HashMap<>();
    private static final ShowroomService showroomService = new ShowroomService(showrooms);
    private static final List<Car> cars = new ArrayList<>(3);

    @BeforeAll
    public static void setUp() {
        showrooms.put(ShowroomBrand.BMW_SHOWROOM.toValue(), new BmwSr());
        showrooms.put(ShowroomBrand.PORSCHE_SHOWROOM.toValue(), new PorscheSr());
        showrooms.put(ShowroomBrand.TOYOTA_SHOWROOM.toValue(), new ToyotaSr());

        cars.add(
                new Car(CarBrand.BMW)
        );
        cars.add(
                new Car(CarBrand.PORSCHE)
        );
        cars.add(
                new Car(CarBrand.TOYOTA)
        );

    }

    @AfterEach
    public void clearShowroom() {
        showrooms.values().forEach(Showroom::clearShowroom);
    }

    @Test
    @DisplayName("Все стоят в своих местах")
    public void carsToTheirShowrooms() {
        for (Car car : cars) {
            assertDoesNotThrow(() ->
                    showroomService.bringCarToShowroom(car, showrooms.get(car.getBrand().toValue())));
        }

        for (Showroom showroom: showrooms.values()){
            assertTrue(CarInRightShowroom(showroom));
        }
    }

    @Test
    @DisplayName("если какой-то дурик перепутал марки машин, и нам пришлось перегонять их")
    public void neTudaTest(){
        assertDoesNotThrow(() -> showroomService.bringCarToShowroom(
                cars.get(2),
                showrooms.get("bmw")
        ));

        assertEquals(showrooms.get("bmw").getCars().size(), 0);

        assertEquals(showrooms.get("toyota").getCars().size(), 1);
        assertEquals(showrooms.get("toyota").getCars().get(0).getBrand(),
                cars.get(2).getBrand());
    }

    private boolean CarInRightShowroom(Showroom showroom) {
        return showroom.getCars().size() == 1
                && showroom.getCars().get(0).getBrand().toValue()
                .equals(showroom.getBrand().toValue());
    }
}
