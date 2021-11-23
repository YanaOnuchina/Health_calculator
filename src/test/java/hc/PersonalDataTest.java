package hc;

import hc.model.Activity;
import hc.model.Gender;
import hc.model.PersonParam;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonalDataTest {

    @Disabled
    @Test
    void getPersonParamFromForm() {
        float norma = 0;
        PersonalData pd = new PersonalData(norma);
        pd.Rost.setText("145");
        pd.Age.setText("30");
        pd.Ves.setText("66.3");
        pd.BoxPol.setSelectedItem(Gender.FEMALE);
        pd.BoxAct.setSelectedItem(Activity.MEDIUM);

        PersonParam result = pd.getPersonParamFromForm();

        assertEquals(66.3f, result.getWeight(), "Invalid Weight value");
        assertEquals(30, result.getAge(), "Invalid Age value");
        assertEquals(145, result.getHeight(), "Invalid Height value");
        assertEquals(Gender.FEMALE, result.getGender(), "Invalid Gender value");
        assertEquals(Activity.MEDIUM, result.getActivity(), "Invalid Activity value");
    }

}
