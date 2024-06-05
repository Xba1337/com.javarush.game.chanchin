import entity.Answer;
import util.AnswersContainer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.jupiter.api.Assertions.*;

public class AnswerContainerClassTest {

    @Test
    public void singletonTest(){
        assertSame(AnswersContainer.getInstance(), AnswersContainer.getInstance());
    }

    @Test
    public void answerListTest(){
        AnswersContainer answersContainer = AnswersContainer.getInstance();
        List<Answer> answersTest = new ArrayList<>();

        answersTest.add(new Answer(11, "Квас"));
        answersTest.add(new Answer(12, "Кефир"));
        answersTest.add(new Answer(21, "Выключить свет и поспешить в постель"));
        answersTest.add(new Answer(22, "Осмотреться"));
        answersTest.add(new Answer(31, "Прижаться к стене"));
        answersTest.add(new Answer(32, "Лечь с краю"));
        answersTest.add(new Answer(41, "Остаться под одеялом и попытаться уснуть"));
        answersTest.add(new Answer(42, "Высунуть ногу и почувствовать живительную прохладу"));
        for (int i = 0; i < answersTest.size(); i++) {

            assertEquals(answersContainer.getAnswers().get(i).getId(), answersTest.get(i).getId());
            assertThat(answersContainer.getAnswers().get(i).getText(), equalToIgnoringWhiteSpace(answersTest.get(i).getText()));
        }
    }
}
