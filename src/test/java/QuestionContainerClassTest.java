import entity.Question;
import util.QuestionsContainer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

public class QuestionContainerClassTest {

    @Test
    public void singletonTest(){
        assertSame(QuestionsContainer.getInstance(), QuestionsContainer.getInstance());
    }

    @Test
    public void questionListTest(){
        QuestionsContainer questionsContainer = QuestionsContainer.getInstance();
        List<Question> questionTest = new ArrayList<>();

        questionTest.add(new Question(1, "Зайдя в квартиру, ты почуствовал ободряющую прохладу, прекрасным окончанием этого рутинного дня стала бы тарелочка твокй любимой окрошки. Быстро настругав овощи и колбасу ты открываешь холодильник,\n" +
                "чтобы добавить последний ингридиент:"));
        questionTest.add(new Question(2, "Завершил трапезу уже затемна, поэтому ты поспешил лечь в постель. Почистив зубы и выйдя из ванной комнаты, тебя объял первобытный страх.\n" +
                "Немного помешкав ты понял из-за чего возникло это чувство - в углу кухню ты увидел странный силуэт похожий на человека."));
        questionTest.add(new Question(3, "Выключив свет, ты что есть мочи побежал в кровать. Прыгнул под одеяло:"));
        questionTest.add(new Question(4, "Ты пролежал несколько часов, но так и не смог уснуть. Ты пытаешься убедить себя, что тот силуэт просто привидился тебе из-за\n" +
                "сильной усталости. Может, если ты вытащишь конечность из-под одеяла тебе станет прохладнее?"));
        questionTest.add(new Question(5, "Из-за сильной усталости и стресса тебе всё-таки удалось уснуть. Ещё один день прожит. Вот такие нелегкие будни заводчанина!"));

        for (int i = 0; i < questionTest.size(); i++) {

            assertEquals(questionsContainer.getQuestions().get(i).getId(), questionTest.get(i).getId());
            assertThat(questionsContainer.getQuestions().get(i).getText(), equalToIgnoringWhiteSpace(questionTest.get(i).getText()));
        }
    }
}
