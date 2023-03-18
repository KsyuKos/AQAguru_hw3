import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;

import java.util.ArrayList;

import static configuration.Config.BASE_URL;
import static configuration.Config.RESOURS_SRC;
import static commands.VerificationModal.verificationModal;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void firstEnterTest() {

        String firstName = "Kseniya",
                lastName = "Kosnyreva",
                fullName = firstName + " " + lastName,
                emailAddress = "kosnireva9469@gmail.com",
                gender = "Female",
                phoneNumber = "7961822211",
                InputBD = "9",
                monthBD = "March",
                yearBD = "2000",
                dayOfBirth = InputBD +" "+ monthBD+","+ yearBD,
                elemSubject = "Economics",
                hobbies = "Reading",
                picture =  "pic.png",
                pictureSrc = RESOURS_SRC + "pic.png",
                currentAddress = "Я гражданин мира",
                elemState = "Haryana",
                elemCity = "Karnal",
                stateAndCity = elemState +" "+ elemCity;


        registrationPage.openUrl("/automation-practice-form").closeBanners();

        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailAddress)
                .setGender(gender)
                .setPhone(phoneNumber)
                .setDate(InputBD, monthBD, yearBD)
                .setSubject(elemSubject)
                .setHobbies(hobbies)
                .uploadFiles(pictureSrc)
                .setCurrentAddress(currentAddress)
                .setState(elemState)
                .setCity(elemCity)
                .clickSubmit();

        verificationModal(fullName, emailAddress, gender, phoneNumber, dayOfBirth,
                elemSubject, hobbies, picture, currentAddress, stateAndCity);


    }
}
