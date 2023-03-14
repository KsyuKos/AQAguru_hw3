package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationModal {

    private static final SelenideElement
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

    //хочется аргументы в коллекцию запихнуть
    public static void verificationModal(String checkFullName,
                                         String checkEmail,
                                         String checkGender,
                                         String checkPhoneNumber,
                                         String checkDayOfBirth,
                                         String checkElemSubject,
                                         String checkHobbies,
                                         String checkPicture,
                                         String checkAddress,
                                         String checkStateAndCity) {
        tableResult.shouldBe(exist);
        fullName.shouldHave(text(checkFullName));
        emailAddress.shouldHave(text(checkEmail));
        gender.shouldHave(text(checkGender));
        phoneNumber.shouldHave(text(checkPhoneNumber));
        dayOfBirth.shouldHave(text(checkDayOfBirth));
        elemSubject.shouldHave(text(checkElemSubject));
        hobbies.shouldHave(text(checkHobbies));
        picture.shouldHave(text(checkPicture));
        address.shouldHave(text(checkAddress));
        stateAndCity.shouldHave(text(checkStateAndCity));
    }

}
