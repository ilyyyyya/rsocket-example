package org.example.clientrsocket.dto;

import org.example.clientrsocket.model.Cat;

import java.util.List;

public class CatListWrapper {
    private List<Cat> cats;

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
