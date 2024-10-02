package org.example.clientrsocket.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cat {
    private Long id;
    private String name;
    private int age;
    private String color;
    private String breed;
}
