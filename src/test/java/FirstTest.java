import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void firstEnterTest() {

        String firstName = "Kseniya",
                lastName = "Kosnyreva",
                emailAddress = "kosnireva9469@gmail.com",
                gender = "Female",
                phoneNumber = "7961822211",
                InputBD = "9",
                monthBD = "March",
                yearBD = "2000",
                elemSubject = "Economics",
                hobbies = "Reading",
                picture = "src/test/resources/pic.png",
                currentAddress = "Я гражданин мира",
                elemState = "Haryana",
                elemCity = "Karnal";

        registrationPage.openUrl("/automation-practice-form");

        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailAddress)
                .setGender(gender)
                .setPhone(phoneNumber)
                .setDate(InputBD, monthBD, yearBD)
                .setSubject(elemSubject)
                .setHobbies(hobbies)
                .uploadFiles(picture) //по хорошему часть пути нужно вынести в конфиг файл в ресурсы
                .setCurrentAddress(currentAddress)
                .setState(elemState)
                .setCity(elemCity)
                .clickSubmit();

        $x("//div[@class='table-responsive']").shouldBe(exist);
        $x("//tr[contains(.,'Student Name')]/td[last()]").shouldHave(text("Kseniya Kosnyreva"));
        $x("//tr[contains(.,'Student Email')]/td[last()]").shouldHave(text("kosnireva9469@gmail.com"));
        $x("//tr[contains(.,'Gender')]/td[last()]").shouldHave(text("Female"));
        $x("//tr[contains(.,'Mobile')]/td[last()]").shouldHave(text("7961822211"));
        $x("//tr[contains(.,'Date of Birth')]/td[last()]").shouldHave(text("09 March,2000"));
        $x("//tr[contains(.,'Subjects')]/td[last()]").shouldHave(text("Economics"));
        $x("//tr[contains(.,'Hobbies')]/td[last()]").shouldHave(text("Reading"));
        $x("//tr[contains(.,'Picture')]/td[last()]").shouldHave(text("pic.png"));
        $x("//tr[contains(.,'Address')]/td[last()]").shouldHave(text("Я гражданин мира"));
        $x("//tr[contains(.,'State and City')]/td[last()]").shouldHave(text("Haryana Karnal"));

    }
}
