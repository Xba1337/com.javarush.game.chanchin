package com.javarush.game.chanchin.game.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionsContainer {

    private static QuestionsContainer instance;

    private QuestionsContainer() {

    }

    private static List<Question> questions;

    public static QuestionsContainer getInstance() {
        if (instance == null) {
            instance = new QuestionsContainer();
            questions = fillQuestionsList("C:\\Games\\master\\com.javarush.game.chanchin\\" +
                    "src\\main\\java\\com\\javarush\\game\\chanchin\\game\\resources\\sceneryQuestions.txt");
        }
        return instance;
    }


    public static List<Question> fillQuestionsList(String path) {
        String fileContent = "";
        List<Question> result = new ArrayList<>();
        try {
            fileContent = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        String[] splitedString = StringUtils.split(fileContent, "#");

        for (String s : splitedString) {
            String sID = StringUtils.substringBetween(s, "№", ":");
            Integer id = Integer.parseInt(sID);
            String question = StringUtils.substringBetween(s, "\"", "\"");
            result.add(new Question(id, question));
        }
        return result;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
