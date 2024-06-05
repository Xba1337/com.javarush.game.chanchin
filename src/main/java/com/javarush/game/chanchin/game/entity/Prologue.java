package com.javarush.game.chanchin.game.entity;


import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Data
public class Prologue {

    private static Prologue instance;

    private Prologue() {

    }

    private static String prologueText;

    public static Prologue getInstance() {
        if (instance == null) {
            instance = new Prologue();
            prologueText = fillPrologue();
        }
        return instance;
    }

    public static String fillPrologue() {
        String fileContent = "";
        try {
            fileContent = Files.readString(Path.of("C:\\Games\\master\\com.javarush.game.chanchin\\" +
                    "src\\main\\java\\com\\javarush\\game\\chanchin\\game\\prologue.txt"));
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return fileContent;
    }

    public String getPrologueText() {
        return prologueText;
    }


}
