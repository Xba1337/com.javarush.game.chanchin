package com.javarush.game.chanchin.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {

    private Integer id;
    private String text;
}
