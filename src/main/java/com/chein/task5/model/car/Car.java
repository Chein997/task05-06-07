package com.chein.task5.model.car;

import java.time.LocalDate;
import java.time.MonthDay;

public class Car {

    private CarBrand carBrand;
    private LocalDate dispatchDate;
    private MonthDay deliveryDays;


    public Car(CarBrand carBrand) {
        this.carBrand = carBrand;
        this.dispatchDate = dispatchDate;
        this.deliveryDays = deliveryDays;
    }

    public void setBrand(CarBrand carBrand){
        this.carBrand = carBrand;
    }

    public CarBrand getBrand() {
        return carBrand;
    }

    public void setDispatchDate(LocalDate dispatchDate){
        this.dispatchDate = dispatchDate;
    }
    public LocalDate getDispatchDate(){
        return dispatchDate;
    }
    public void setDeliveryDays(MonthDay deliveryDays){
        this.deliveryDays = deliveryDays;
    }

    public MonthDay getDeliveryDays(){
        return deliveryDays;
    }
}
