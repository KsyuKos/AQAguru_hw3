import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    BasePage page = new BasePage();

    @Test
    void firstEnterTest() {
        page.openUrl("/automation-practice-form");
        executeJavaScript("$('footer').css('position','relative')"); //костыльчик, просто убрать футер не помогло
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        page.setFirstName("Kseniya");
        page.setLastName("Kosnyreva");
        page.setEmail("kosnireva9469@gmail.com");
        page.setGender("Female");
        page.setPhone("7961822211");
        page.setDate("9","March","2000");
        page.setSubject("Economics");
        page.setHobbies("Reading");
        page.uploadFiles("src/test/resources/pic.png"); //по хорошему часть пути нужно вынести в конфиг файл в ресурсы
        page.setCurrentAddress("Я гражданин мира");
        page.setState("Haryana");
        page.setCity("Karnal");

        page.clickSubmit();

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
