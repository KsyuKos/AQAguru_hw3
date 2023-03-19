package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegisrationModalWindow {

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


    public SelenideElement getTableResult() {
        return tableResult;
    }

    public SelenideElement getFullName() {
        return fullName;
    }

    public SelenideElement getEmailAddress() {
        return emailAddress;
    }

    public SelenideElement getGender() {
        return gender;
    }

    public SelenideElement getPhoneNumber() {
        return phoneNumber;
    }

    public SelenideElement getDayOfBirth() {
        return dayOfBirth;
    }

    public SelenideElement getElemSubject() {
        return elemSubject;
    }

    public SelenideElement getHobbies() {
        return hobbies;
    }

    public SelenideElement getPicture() {
        return picture;
    }

    public SelenideElement getAddress() {
        return address;
    }

    public SelenideElement getStateAndCity() {
        return stateAndCity;
    }

}
