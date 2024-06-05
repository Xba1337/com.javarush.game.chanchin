package util;


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
            prologueText = fillPrologue("C:\\Games\\master\\com.javarush.game.chanchin\\" +
                    "src\\main\\resources\\prologue.txt");
        }
        return instance;
    }

    public static String fillPrologue(String path) {
        String fileContent = "";
        try {
            fileContent = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return fileContent;
    }

    public String getPrologueText() {
        return prologueText;
    }


}
