package com.codestates.preproject.vote.enums;

public enum OpinionEnum {
    LIKE(1),
    DISLIKE(-1);

    private final int value;

    private OpinionEnum(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

}
