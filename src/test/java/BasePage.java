import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    public void openUrl(String url) {
        open(url);
    }

    public BasePage setFirstName (String fname) {
        $("#firstName").setValue(fname);
        return this;
    }

    public BasePage setLastName (String lname) {
        $("#lastName").setValue(lname);
        return this;
    }

    public BasePage setEmail (String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public BasePage setGender (String gender) {
        $(byText(gender)).click();
        return this;
    }

    public BasePage setPhone (String phone) {
        $x("//input[@id='userNumber']").setValue(phone);
        return this;
    }
//не понимаю, почему не вычищает поле даты
    public BasePage setDate (String date) {
        SelenideElement el = $x("//input[@id='dateOfBirthInput']");
        el.setValue("");
        el.setValue(date).pressEnter();
        return this;
    }

    public BasePage setSubject (String subject) {
        $x("//input[@id='subjectsInput']").setValue(subject).pressEnter();
        return this;
    }

    public BasePage setHobbies (String hobbies) {
        $(byText(hobbies)).click();
        return this;
    }

    public BasePage uploadFiles (String url) {
        File file = new File(url);
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public BasePage setCurrentAddress (String address) {
        $x("//textarea[@id='currentAddress']").setValue(address);
        return this;
    }

    public BasePage setState (String state) {
        $x("//input[@id='react-select-3-input']").setValue(state).pressEnter();
        return this;
    }
//была мысль заверуть в условный оператор, учесть неактивность поля из-за невыбранного штата
    public BasePage setCity (String city){
        $x("//input[@id='react-select-4-input']").setValue(city).pressEnter();
        return this;
    }

    public BasePage clickSubmit (){
        $x("//button[@id='submit']").click();
        return this;
    }

}
