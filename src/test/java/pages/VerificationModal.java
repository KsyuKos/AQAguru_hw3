package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationModal {

    private final SelenideElement
            tableResult = $x("//div[@class='table-responsive']"),
            fullName =  $x("//tr[contains(.,'Student Name')]/td[last()]"),
            emailAddress = $x("//tr[contains(.,'Student Email')]/td[last()]"),
            gender = $x("//tr[contains(.,'Gender')]/td[last()]"),
            phoneNumber = $x("//tr[contains(.,'Mobile')]/td[last()]"),
            dayOfBirth =  $x("//tr[contains(.,'Date of Birth')]/td[last()]"),
            elemSubject = $x("//tr[contains(.,'Subjects')]/td[last()]"),
            hobbies = $x("//tr[contains(.,'Hobbies')]/td[last()]"),
            picture = $x("//tr[contains(.,'Picture')]/td[last()]"),
            address = $x("//tr[contains(.,'Address')]/td[last()]"),
            stateAndCity = $x("//tr[contains(.,'State and City')]/td[last()]");

    private void verificationModal (String args[]) {
        tableResult.shouldBe(exist);
        fullName.shouldHave(text("Kseniya Kosnyreva"));
        emailAddress.shouldHave(text("kosnireva9469@gmail.com"));
        gender.shouldHave(text("Female"));
        phoneNumber.shouldHave(text("7961822211"));
        dayOfBirth.shouldHave(text("09 March,2000"));
        elemSubject.shouldHave(text("Economics"));
        hobbies.shouldHave(text("Reading"));
        picture.shouldHave(text("pic.png"));
        address.shouldHave(text("Я гражданин мира"));
        stateAndCity.shouldHave(text("Haryana Karnal"));
    }

}
