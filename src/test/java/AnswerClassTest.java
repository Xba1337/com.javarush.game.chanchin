import entity.Answer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerClassTest {

    @Test
    public void getIdTest(){
        Answer answer = new Answer(7357, "Test");
        assertEquals(7357, answer.getId());
    }

    @Test
    public void getTextTest(){
        Answer answer = new Answer(7357, "Test");
        assertEquals("Test", answer.getText());
    }
}
