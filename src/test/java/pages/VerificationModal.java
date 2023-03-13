package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationModal {

    private final SelenideElement
            tableResult = $x("//div[@class='table-responsive']"),
            fullName =  $x("//tr[contains(.,'Student Name')]/td[last()]"),
            emailAddress = $x("//tr[contains(.,'Student Email')]/td[last()]"),
            phoneNumber = $x("//tr[contains(.,'Mobile')]/td[last()]"),
            dayOfBirth =  $x("//tr[contains(.,'Date of Birth')]/td[last()]"),
            elemSubject = $x("//tr[contains(.,'Subjects')]/td[last()]"),
            hobbies = $x("//tr[contains(.,'Hobbies')]/td[last()]"),
            currentAddress = $x("//textarea[@id='currentAddress']"),
            picture = $x("//tr[contains(.,'Picture')]/td[last()]"),
            address = $x("//tr[contains(.,'Address')]/td[last()]"),
            elemCity = $x("//input[@id='react-select-4-input']"),
            stateAndCity = $x("//tr[contains(.,'State and City')]/td[last()]");

    private void verificationModal (String args[]) {

    }

}
