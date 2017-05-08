package com.aequilibrium.Transformer;

import com.aequilibrium.Exception.AttributeException;

public class Attribute {
    public static final int ATTRIBUTE_MIN_VALUE = 0;
    public static final int ATTRIBUTE_MAX_VALUE = 10;
    private int value = 0;

    public Attribute(int value) throws AttributeException {
        if(value < ATTRIBUTE_MIN_VALUE || value > ATTRIBUTE_MAX_VALUE)
            throw new AttributeException();

        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

