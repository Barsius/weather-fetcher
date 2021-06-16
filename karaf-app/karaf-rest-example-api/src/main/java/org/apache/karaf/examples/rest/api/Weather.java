package org.apache.karaf.examples.rest.api;

public class Weather {
    private String name;

    public Weather() {

    }

    public Weather(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
