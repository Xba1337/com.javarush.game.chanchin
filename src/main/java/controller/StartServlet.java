package controller;


import entity.*;
import util.AnswersContainer;
import util.Counter;
import config.Statements;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Prologue;
import util.QuestionsContainer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FirstQuestionServlet", value = "/first")
public class StartServlet extends HttpServlet {

    static AnswersContainer answersContainer = AnswersContainer.getInstance();
    static QuestionsContainer questionsContainer = QuestionsContainer.getInstance();
    static List<Question> questions = questionsContainer.getQuestions();
    static List<Answer> answers = answersContainer.getAnswers();
    static Prologue prologue = Prologue.getInstance();

    static int gottenID;
    static int convertedQuestionID;
    static int remainder;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Answer> attributeAnswer = new ArrayList<>();

        if (request.getParameter("id") != null) {
            gottenID = Integer.parseInt(request.getParameter("id"));
            convertedQuestionID = convertFromAnswToQuestID(gottenID);
            remainder = convertToSingleDigit(gottenID);

            if (Integer.parseInt(request.getParameter("id")) == Statements.PROLOGUE) {
                gottenID = Statements.POSITIVE_ANSWER;
                convertedQuestionID = convertFromAnswToQuestID(gottenID);
                remainder = convertToSingleDigit(gottenID);
            }

        } else {
            gottenID = Statements.PROLOGUE;
            remainder = Statements.PROLOGUE;
        }

        switch (remainder) {
            case Statements.PROLOGUE: {
                String prologueText = prologue.getPrologueText();
                request.setAttribute("questionID", gottenID);
                request.setAttribute("questionText", prologueText);
            }
            break;
            case Statements.POSITIVE_ANSWER: {
                Integer questionID = questions.get(convertedQuestionID)
                                              .getId();
                String questionText = questions.get(convertedQuestionID)
                                               .getText();
                request.setAttribute("questionID", questionID);
                request.setAttribute("questionText", questionText);
                for (int i = 0; i < answers.size(); i++) {
                    int answerID = answers.get(i)
                                          .getId();
                    if (convertFromAnswToQuestID(answerID) == questionID) {
                        attributeAnswer.add(answers.get(i));
                    }
                }
                request.setAttribute("answers", attributeAnswer);
            }
            break;

            case Statements.NEGATIVE_ANSWER: {
                Integer loseID = Statements.LOSE;
                String loseText;
                if (convertedQuestionID == 1) {
                    loseText = "На кефире? Серьезно? Пересмотри свою жизненную позицию и попробуй заново";
                    request.setAttribute("questionID", loseID);
                    request.setAttribute("questionText", loseText);
                }
                if (convertedQuestionID == 2) {
                    loseText = "Когда ты подошёл ближе, ты понял, что тебе это точно не причудилось. " +
                            "В углу кухни стоял нечестивый образ тебя же самого. Концентрат всех твоих грязных мыслей и деяний. " +
                            "Взглянув на него, ты как завороженный открыл холодильник, достал сиську пива и всю ночь играл в танки и проспал работу. " +
                            "Это был последний прогул в твоей жизни, тебя уволили.";
                    request.setAttribute("questionID", loseID);
                    request.setAttribute("questionText", loseText);
                }
                if (convertedQuestionID == 3) {
                    loseText = "Серенький волчок откусил тебе бок. Эх, говорила тебе мама!";
                    request.setAttribute("questionID", loseID);
                    request.setAttribute("questionText", loseText);
                }
                if (convertedQuestionID == 4) {
                    loseText = "У тебя никогда не было страха в детстве, что тебя может съесть бабайка, " +
                            "если ты высунешься из-под этого квадратного, мягкого, нерушимого оплота? Нет? А это была правда!";
                    request.setAttribute("questionID", loseID);
                    request.setAttribute("questionText", loseText);
                }
            }
        }
        if (remainder == Statements.NEGATIVE_ANSWER) {
            Counter.addLoses();
        }
        int numberOfLoses = Counter.getLoses();

        request.setAttribute("numberOfLoses", numberOfLoses);

        request.getRequestDispatcher("start.jsp")
               .forward(request, response);
    }

    public int convertToSingleDigit(int number) {
        if (number < 10) {
            return number;
        }
        return number % 10;
    }

    public int convertFromAnswToQuestID(int answerID) {
        return answerID / 10;
    }
}
