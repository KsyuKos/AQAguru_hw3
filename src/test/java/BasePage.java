import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.io.File;

import static com.codeborne.selenide.Condition.exactOwnText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    protected String numberDay;

    private final SelenideElement
        firstName =  $("#firstName"),
        lastName = $("#lastName"),
        emailAddress = $("#userEmail"),
        phoneNumber = $x("//input[@id='userNumber']"),
        InputBD = $x("//input[@id='dateOfBirthInput']"),
        monthBD = $x("//select[@class='react-datepicker__month-select']"),
        yearBD = $x("//select[@class='react-datepicker__year-select']"),
        elemSubject = $x("//input[@id='subjectsInput']"),
        picture = $("#uploadPicture"),
        currentAddress = $x("//textarea[@id='currentAddress']"),
        elemState = $x("//input[@id='react-select-3-input']"),
        elemCity = $x("//input[@id='react-select-4-input']"),
        elemSubmit = $x("//button[@id='submit']");

    ElementsCollection dayBD = $$x("//div[@class= 'react-datepicker__week']//child::div[contains(@class, 'react-datepicker__day')]");

    public void openUrl(String url) {
        open(url);
    }

    public BasePage setFirstName (String fname) {
        firstName.setValue(fname);
        return this;
    }

    public BasePage setLastName (String lname) {
        lastName.setValue(lname);
        return this;
    }

    public BasePage setEmail (String email) {
        emailAddress.setValue(email);
        return this;
    }

    public BasePage setGender (String gender) {
        $(byText(gender)).click();
        return this;
    }

    public BasePage setPhone (String phone) {
        phoneNumber.setValue(phone);
        return this;
    }
//не понимаю, почему не вычищает поле даты
    public BasePage setDate (String date, String month, String year ) {
        numberDay = date;
        InputBD.click();
        monthBD.selectOptionContainingText(month);
        yearBD.selectOptionContainingText(year);
        dayBD.findBy(exactOwnText(date)).click();

        return this;
    }

    public BasePage setSubject (String subject) {
        elemSubject.setValue(subject).pressEnter();
        return this;
    }

    public BasePage setHobbies (String hobbies) {
        $(byText(hobbies)).click();
        return this;
    }

    public BasePage uploadFiles (String url) {
        File file = new File(url);
        picture.uploadFile(file);
        return this;
    }

    public BasePage setCurrentAddress (String address) {
        currentAddress.setValue(address);
        return this;
    }

    public BasePage setState (String state) {
        elemState.setValue(state).pressEnter();
        return this;
    }
//была мысль заверуть в условный оператор, учесть неактивность поля из-за невыбранного штата
    public BasePage setCity (String city){
        elemCity.setValue(city).pressEnter();
        return this;
    }

    public BasePage clickSubmit (){
        elemSubmit.click();
        return this;
    }

}
