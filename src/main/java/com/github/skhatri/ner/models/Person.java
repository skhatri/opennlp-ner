package com.github.skhatri.ner.models;

public class Person implements NERType {
    private final String value;

    public Person(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public String typeName() {
        return "person";
    }
}
