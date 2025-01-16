package org.callcenter;

public enum Rank {
    OPERATOR(0),
    SUPERVISOR(1),
    DIRECTOR(2);

    private final int value;

    Rank(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
