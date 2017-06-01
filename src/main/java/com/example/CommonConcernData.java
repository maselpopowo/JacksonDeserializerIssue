package com.example;

public class CommonConcernData implements ConcernData {

    private Long id;

    public CommonConcernData() {
    }

    public CommonConcernData(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return null;
    }
}
