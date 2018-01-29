package com.github.skhatri.ner.models;

public class Location implements NERType {
    private final String value;

    public Location(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String typeName() {
        return "location";
    }
}
