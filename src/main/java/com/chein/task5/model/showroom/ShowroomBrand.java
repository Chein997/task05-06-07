package com.chein.task5.model.showroom;

public enum ShowroomBrand {
    BMW_SHOWROOM("bmw"),
    PORSCHE_SHOWROOM("porsсhe"),
    TOYOTA_SHOWROOM("toyota");

    private final String value;

    ShowroomBrand(String value) {
        this.value = value;
    }

    public String toValue(){
        return value;
    }
}
