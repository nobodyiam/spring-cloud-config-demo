package com.nobodyiam.spring.cloud.config.demo.model;

/**
 * Created by Jason on 2/25/16.
 */
public class Config {
    private final String name;
    private final String value;

    public Config(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
