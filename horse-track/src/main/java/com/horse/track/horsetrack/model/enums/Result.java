package com.horse.track.horsetrack.model.enums;

public enum Result {

	WIN("win"), LOST("lost");

    private String value;

    private Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
