package commands;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

public class VerificationModal {

    public static void checkExistModal(SelenideElement label) {
        label.should(exist);
    }

    public static void checkVerificationModal(SelenideElement label, String field) {
        label.should(text(field));
        System.out.println("Тест пройден. Значение " + label.getText() + " равно значению " + field);
    }

}
