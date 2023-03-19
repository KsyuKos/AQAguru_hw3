import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegisrationModalWindow;
import pages.RegistrationPage;

import static commands.VerificationModal.*;
import static configuration.Config.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        setConfiguration();
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
                dayOfBirth = InputBD + " " + monthBD + "," + yearBD,
                elemSubject = "Economics",
                hobbies = "Reading",
                picture = "pic.png",
                pictureSrc = resourceSrc + "pic.png",
                currentAddress = "Я гражданин мира",
                elemState = "Haryana",
                elemCity = "Karnal",
                stateAndCity = elemState + " " + elemCity;

        registrationPage.openUrl().closeBanners();

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

        checkExistModal(modalWindow.getTableResult());
        checkVerificationModal(modalWindow.getFullName(), fullName);
        checkVerificationModal(modalWindow.getEmailAddress(), emailAddress);
        checkVerificationModal(modalWindow.getGender(), gender);
        checkVerificationModal(modalWindow.getPhoneNumber(), phoneNumber);
        checkVerificationModal(modalWindow.getDayOfBirth(), dayOfBirth);
        checkVerificationModal(modalWindow.getElemSubject(), elemSubject);
        checkVerificationModal(modalWindow.getHobbies(), hobbies);
        checkVerificationModal(modalWindow.getPicture(), picture);
        checkVerificationModal(modalWindow.getAddress(), currentAddress);
        checkVerificationModal(modalWindow.getStateAndCity(), stateAndCity);
    }
}
