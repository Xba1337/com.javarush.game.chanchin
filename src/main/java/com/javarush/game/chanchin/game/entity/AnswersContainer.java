package com.javarush.game.chanchin.game.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Data
public class AnswersContainer {

    private static AnswersContainer instance;

    private AnswersContainer() {
    }

    private static List<Answer> answers;

    public static AnswersContainer getInstance() {
        if (instance == null) {
            instance = new AnswersContainer();
            answers = fillAnswersList("C:\\Games\\master\\com.javarush.game.chanchin\\" +
                    "src\\main\\java\\com\\javarush\\game\\chanchin\\game\\resources\\scenaryAnswers.txt");
        }
        return instance;
    }

    public static List<Answer> fillAnswersList(String path) {
        List<Answer> result = new ArrayList<>();
        String fileContent = "";
        try {
            fileContent = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        String[] splitedString = StringUtils.split(fileContent, "#");

        for (String s : splitedString) {
            String sID = StringUtils.substringBetween(s, "№", ":");
            Integer id = Integer.parseInt(sID);
            String answer = StringUtils.substringBetween(s, "\"", "\"");
            result.add(new Answer(id, answer));
        }

        return result;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
