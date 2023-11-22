package com.example.rmi.component;

import java.io.Serializable;

public enum OperatorType implements Serializable {
    MORE(">"),
    MORE_OR_EQUAL(">="),
    EQUAL("=="),
    EQUAL_OR_LESS("<="),
    LESS("<");

    String value;

    OperatorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}