import util.Prologue;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PrologueClassTest {

    @Test
    public void singletonTest(){
        assertSame(Prologue.getInstance(), Prologue.getInstance());
    }

    @Test
    public void prologueListTest(){
        Prologue prologue = Prologue.getInstance();
        String prologueText = prologue.getPrologueText();
        String testText = "Ты работаешь на заводе. Сегодня был долгий и нудный день. Ты волочешь ноги по расскаленному асфальту.\n" +
                "Солнце, возвышающееся в небе, настолько жаркое, что ослепляет тебя черным светом и окружающие тебя бетонные зубы панелек иллюзорно плавятся от его лучей и пачкают серым цветом пейзаж.\n" +
                "Всё, что ты сейчас хочешь - это вернуться в свою квартиру.";

        assertThat(prologueText, equalToIgnoringWhiteSpace(testText));

    }
}

