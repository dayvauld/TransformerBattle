package com.aequilibrium.Exception;

public class AttributeException extends RuntimeException{
    public AttributeException() {
        super("Attribute Value is outside of range min:0 max:10");
    }
}
