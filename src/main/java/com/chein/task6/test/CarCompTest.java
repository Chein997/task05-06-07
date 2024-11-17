package com.chein.task6.test;

import com.chein.task6.comporator.CarComparator;
import com.chein.task6.model.Builder;
import com.chein.task6.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarCompTest {

    private static final String CAR_1 = "BMW M3";
    private static final int HORSEPOWER_CAR1 = 650;
    private static final String CAR_2 = "NISSAN GTR";
    private static final int HORSEPOWER_CAR2 = 1000;
    private static final String NAME1 = "Alex";
    private static final String SURNAME1 = "May";
    private static final String NAME2 = "AAark";
    private static final String SURNAME2 = "Aop";
    private static final LocalDate DATE_OF_BIRTH1 = LocalDate.of(1999, 5, 31);
    private static final LocalDate DATE_OF_BIRTH2 = LocalDate.of(1976, 5, 31);

    private static List<Car> sortByBrand;
    private static List<Car> sortByBrandAndBuilder;
    @BeforeAll
    public static void setUp() {
        sortByBrand = getSortByBrand();
        sortByBrandAndBuilder = getSortByBrandAndBuilder();
    }


    @Test
    @DisplayName("Сортировка по марке")
    public void sortBookByTitle(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car()
                .setBrand(CAR_2)
                .setHorsePower(HORSEPOWER_CAR2)
                .setBuilder(
                        new Builder()
                                .setName(NAME2)
                                .setSurname(SURNAME2)
                                .setBirthDay(DATE_OF_BIRTH2)
                ));

        cars.add(new Car()
                .setBrand(CAR_1)
                .setHorsePower(HORSEPOWER_CAR1)
                .setBuilder(
                        new Builder()
                                .setName(NAME1)
                                .setSurname(SURNAME1)
                                .setBirthDay(DATE_OF_BIRTH1)
                ));

        cars.sort(new CarComparator());

        for (int i = 0; i < cars.size(); i++) {
            assertEquals(sortByBrand.get(i), cars.get(i));
        }
    }

    @Test
    @DisplayName("Сортировка только по количеству страниц и автору")
    public void sortCarBrandAndBuilder(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car()
                .setBrand(CAR_2)
                .setHorsePower(HORSEPOWER_CAR2)
                .setBuilder(
                        new Builder()
                                .setName(NAME2)
                                .setSurname(SURNAME2)
                                .setBirthDay(DATE_OF_BIRTH2)
                ));

        cars.add(new Car()
                .setBrand(CAR_1)
                .setHorsePower(HORSEPOWER_CAR1)
                .setBuilder(
                        new Builder()
                                .setName(NAME1)
                                .setSurname(SURNAME1)
                                .setBirthDay(DATE_OF_BIRTH1)
                ));

        cars.sort(Comparator.comparing(Car::getHorsePower).thenComparing(Car::getBuilder));

        for (int i = 0; i < cars.size(); i++) {
            assertEquals(sortByBrandAndBuilder.get(i), cars.get(i));
        }
    }

    @Test
    public void checkCar(){
        Car car1 = new Car()
                .setBrand(CAR_2)
                .setHorsePower(HORSEPOWER_CAR2);

        Car car2 =new Car()
                .setBrand(CAR_1)
                .setHorsePower(HORSEPOWER_CAR1);
        assertTrue(car1.equals(car2));
    }

    @Test
    public void CheckBuilder(){
        Builder builder1 = new Builder()
                        .setName(NAME1)
                        .setSurname(SURNAME1)
                        .setBirthDay(DATE_OF_BIRTH1);
        Builder builder2 = new Builder()
                .setName(NAME2)
                .setSurname(SURNAME2)
                .setBirthDay(DATE_OF_BIRTH2);
        assertEquals(0, builder1.compareTo(builder2));
    }

    public static List<Car> getSortByBrand(){
        return List.of(
                new Car()
                        .setBrand(CAR_1)
                        .setHorsePower(HORSEPOWER_CAR1)
                        .setBuilder(
                                new Builder()
                                        .setName(NAME1)
                                        .setSurname(SURNAME1)
                                        .setBirthDay(DATE_OF_BIRTH1)
                        ),
                new Car()
                        .setBrand(CAR_2)
                        .setHorsePower(HORSEPOWER_CAR2)
                        .setBuilder(
                                new Builder()
                                        .setName(NAME2)
                                        .setSurname(SURNAME2)
                                        .setBirthDay(DATE_OF_BIRTH2)
                        )
        );
    }

    public static List<Car> getSortByBrandAndBuilder(){
        return List.of(
                new Car()
                        .setBrand(CAR_1)
                        .setHorsePower(HORSEPOWER_CAR1)
                        .setBuilder(
                                new Builder()
                                        .setName(NAME1)
                                        .setSurname(SURNAME1)
                                        .setBirthDay(DATE_OF_BIRTH1)
                        ),
                new Car()
                        .setBrand(CAR_2)
                        .setHorsePower(HORSEPOWER_CAR2)
                        .setBuilder(
                                new Builder()
                                        .setName(NAME2)
                                        .setSurname(SURNAME2)
                                        .setBirthDay(DATE_OF_BIRTH2)
                        )
        );
    }
}
