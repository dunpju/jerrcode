package com.yumi.jerrcode;

public interface CodeInterface {
    public default void process() {
        System.out.println(this.getClass().getDeclaredFields());
    }
}
