package hc.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Tester class.
 */
class PersonParamTest {

    static final PersonParam NORMAL_PERSON = new PersonParam() {{
       setWeight(60);
       setAge(25);
       setHeight(164);
       setGender(Gender.FEMALE);
       setActivity(Activity.MEDIUM);
    }};

    @Test
    void getNormaSuccess() {
        float result = NORMAL_PERSON.getNorma();
        assertEquals(2197.3f, result, "Ожидается конкретное значение");
    }

    @Test
    void getNormaWhenWeightIsZero() {
        PersonParam pp = NORMAL_PERSON.clone();
        pp.setWeight(0);

        float result = pp.getNorma();
        assertTrue(result > 0, "Ожидается норма больше нуля");
    }


}