package com.chein.task5.test;

import com.chein.task5.exceptions.DateException;
import com.chein.task5.model.car.Car;
import com.chein.task5.model.car.CarBrand;
import com.chein.task5.service.CarService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarServiceTest {
    private static final LocalDate DATE = LocalDate.of(2024, 11, 2);
    private static final MonthDay MONTH_DAY = MonthDay.of(12, 2);
    private static final String VALID_DATE = "2024-11-02";
    private static final String INVALID_DATE = "2024/11/02";
    private static final String VALID_MONTH_DAY = "--12-02";
    private static final String INVALID_MONTH_DAY = "--12-12";

    private final Car car = new Car(CarBrand.BMW);

    private final CarService carService = new CarService();

    @Test
    @DisplayName("Дата отправки верная, ошибки не будет")
    public void DispatchDatePTest() {
        carService.setDispatchDate(car, VALID_DATE);

        assertEquals(car.getDispatchDate(), DATE);
    }

    @Test
    @DisplayName("Ошибка даты отправки")
    public void DispatchDateNTest() {
        carService.setDispatchDate(car, INVALID_DATE);

        assertEquals(car.getDispatchDate(), DATE);
    }

    @Test
    @DisplayName("День, когда будет доставка устраивает")
    public void DeliveryDaysPTest() {
        carService.setDeliveryDays(car, VALID_MONTH_DAY, VALID_MONTH_DAY);

        assertEquals(car.getDeliveryDays(), MONTH_DAY);
    }

    @Test
    @DisplayName("День, когда будет поставка не устраивает")
    public void DeliveryDaysNTest() {
        carService.setDeliveryDays(car, VALID_MONTH_DAY, INVALID_MONTH_DAY);

        assertEquals(car.getDeliveryDays(), MONTH_DAY);
    }
}
