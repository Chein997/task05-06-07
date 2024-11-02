package com.chein.task5.model.car;

public enum CarBrand {
    BMW("bmw"),
    PORSCHE("porsсhe"),
    TOYOTA("toyota");

    private final String value;

    CarBrand(String value) {
        this.value = value;
    }

    public String toValue(){
        return value;
    }

}
