package com.horse.track.horsetrack.model.enums;

public enum Doller {

	HUNDRED(100), TWENTY(20), TEN(10), FIVE(5), ONE(1);

    private int value;

    private Doller(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
