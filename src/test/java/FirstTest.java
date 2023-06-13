import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegisrationModalWindow;
import pages.RegistrationPage;

import static commands.RandomTestData.*;
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


        registrationPage.openPage().closeBanners();
        registrationPage
                .setFirstName(firstName)
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
        checkVerificationModal(modalWindow.getPicture(), pictureName);
        checkVerificationModal(modalWindow.getAddress(), currentAddress);
        checkVerificationModal(modalWindow.getStateAndCity(), stateAndCity);
    }
}
