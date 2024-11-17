package com.chein.task6.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Objects;

@Getter
@Setter
@Data
@Accessors(chain = true)

public class Car {

    private String brand;
    private int horsePower;
    private Builder builder;

    @Override
    public int hashCode() {
        return Objects.hash(brand, builder);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(builder, car.builder);
    }

}
