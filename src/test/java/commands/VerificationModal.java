package commands;

import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
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

        ArrayList<SelenideElement> array = new ArrayList<>();
        array.add(tableResult);
        array.add(fullName);
        array.add(emailAddress);
        array.add(gender);
        array.add(phoneNumber);
        array.add(dayOfBirth);
        array.add(elemSubject);
        array.add(hobbies);
        array.add(picture);
        array.add(address);
        array.add(stateAndCity);

        int index = 0;
        for (SelenideElement element : array) {
            if (element.should(text(checkDayOfBirth)) instanceof SelenideElement) {
                System.out.println("Тест пройден" + checkDayOfBirth);
                break;
            } else {
                index++;
            }
        }

        /*tableResult.should(exist);
        fullName.should(text(checkFullName));
        emailAddress.should(text(checkEmail));
        gender.should(text(checkGender));
        phoneNumber.should(text(checkPhoneNumber));
        dayOfBirth.should(text(checkDayOfBirth));
        elemSubject.should(text(checkElemSubject));
        hobbies.should(text(checkHobbies));
        picture.should(text(checkPicture));
        address.should(text(checkAddress));
        stateAndCity.should(text(checkStateAndCity));*/
    }

}
