package com.github.skhatri.ner.models;

public class TypeFactory {

    public static final NERType create(String typeName, String value) {
        switch (typeName) {
            case "person":
                return new Person(value);
            case "location":
                return new Location(value);
            default:
                throw new RuntimeException("bad ner type");
        }
    }
}
