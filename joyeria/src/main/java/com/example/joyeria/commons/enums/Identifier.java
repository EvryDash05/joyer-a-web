package com.example.joyeria.commons.enums;

import lombok.Getter;

@Getter
public enum Identifier {
    CUSTOMER("CST"),
    PAYMENT("PMT"),
    SHIPMENT("SPM"),
    ORDER("ORD"),
    CART("CRT"),
    PRODUCT("PRD");

    private final String value;

    Identifier(String value) {
        this.value = value;
    }
}
