import com.javarush.game.chanchin.game.entity.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionClassTest {

    @Test
    public void getIdTest(){
        Question question = new Question(7357, "Test");
        assertEquals(7357, question.getId());
    }

    @Test
    public void getTextTest(){
        Question question = new Question(7357, "Test");
        assertEquals("Test", question.getText());
    }
}
