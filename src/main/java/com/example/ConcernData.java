package com.example;

public interface ConcernData {

    Long getId();

    default <T> T as(Class<T> type) {
        if (type.isAssignableFrom(this.getClass())) {
            return (T) this;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
