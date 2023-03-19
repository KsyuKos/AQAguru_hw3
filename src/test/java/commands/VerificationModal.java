package commands;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

public class VerificationModal {

    public static void verificationModal(SelenideElement label, String field) {
        label.should(text(field));
        System.out.println("Тест пройден " + field);
    }

    public static void existModal(SelenideElement label) {
        label.should(exist);
    }

}
