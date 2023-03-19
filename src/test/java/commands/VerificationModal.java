package commands;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationModal {

    private static final SelenideElement
            tableResult = $x("//div[@class='table-responsive']");

    public static void verificationModal(String field) {
            tableResult.should(text(field));
            System.out.println("Тест пройден " + field);
        }

}
