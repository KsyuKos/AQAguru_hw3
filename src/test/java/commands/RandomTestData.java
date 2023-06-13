package commands;

import com.github.javafaker.Faker;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static configuration.Config.resourceSrc;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class RandomTestData {

    private static final String[] allMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "September",
            "November", "December"};
    private static final String[] allHobbies = {"Sports", "Reading", "Other"};
    private static final String[] someSubject = {"Economics", "English", "Biology", "Commerce", "Arts", "Social Studies"};
    public static String pictureName = "pic.png";

    static Faker faker = new Faker();

    public static @NotNull String getRandomString(int length) {
        return randomAlphabetic(length);
    }

    public static int getRandomNumber(int max, int min) {
        Random randomNum = new Random();
        return randomNum.nextInt(max - min) + min;
    }

    public static @NotNull String getRandomEmail(int length) {
        return getRandomString(6) + "@digimatics.ru";
    }

    public static String getRandomElemOfArr(String @NotNull [] values) {
        int index = getRandomNumber(values.length - 1, 0);
        return values[index];
    }

    public static String getRandomMonth() {
        return getRandomElemOfArr(allMonth);
    }

    public static String getRandomHobbies() {
        return getRandomElemOfArr(allHobbies);
    }

    public static String getRandomSubjects() {
        return getRandomElemOfArr(someSubject);
    }

    static Map<String, String[]> mapCityToState = new HashMap<>(Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    ));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = firstName + " " + lastName,
            emailAddress = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phoneNumber = String.valueOf(faker.number().digits(10)),
            InputBD = String.valueOf(faker.number().numberBetween(0,31)),
            monthBD = getRandomMonth(),
            yearBD = String.valueOf(faker.number().numberBetween(1900,2023)),
            dayOfBirth = InputBD + " " + monthBD + "," + yearBD,
            elemSubject = getRandomSubjects(),
            hobbies = getRandomHobbies(),
            pictureSrc = resourceSrc + pictureName,
            currentAddress = faker.address().fullAddress(),
            elemState = faker.options().option(mapCityToState.keySet().toArray()).toString(),
            elemCity = faker.options().option(mapCityToState.get(elemState)),
            stateAndCity = elemState + " " + elemCity;

}
