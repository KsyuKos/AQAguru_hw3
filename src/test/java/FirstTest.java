import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegisrationModalWindow;
import pages.RegistrationPage;

import static commands.VerificationModal.existModal;
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
    RegisrationModalWindow modalWindow = new RegisrationModalWindow();

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

        existModal(modalWindow.getTableResult());
        verificationModal(modalWindow.getFullName(),fullName);
        verificationModal(modalWindow.getEmailAddress(),emailAddress);
        verificationModal(modalWindow.getGender(),gender);
        verificationModal(modalWindow.getPhoneNumber(),phoneNumber);
        verificationModal(modalWindow.getDayOfBirth(),dayOfBirth);
        verificationModal(modalWindow.getElemSubject(),elemSubject);
        verificationModal(modalWindow.getHobbies(),hobbies);
        verificationModal(modalWindow.getPicture(),picture);
        verificationModal(modalWindow.getAddress(),currentAddress);
        verificationModal(modalWindow.getStateAndCity(),stateAndCity);
    }
}
