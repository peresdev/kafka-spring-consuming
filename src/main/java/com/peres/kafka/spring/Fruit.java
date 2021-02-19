package com.peres.kafka.spring;

import java.util.UUID;

public class Fruit {
    private String name;

    public String getName() {
        return name;
    }

    public Fruit setName(String name) {
        this.name = name + "-" + UUID.randomUUID();
        return this;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }
}
