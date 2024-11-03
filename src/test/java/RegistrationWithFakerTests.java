import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;
import java.util.Locale;
import static utils.RandomUtils.getRandomCityByState;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker(new Locale("de"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String invalidUserNumber = faker.phoneNumber().subscriberNumber(9);
    String userAddress = faker.address().streetAddress();
    String userSubject = faker.options().option("Accounting", "Maths", "Arts", "Social Studies", "Chemistry", "Computer Science", "Commerce", "Physics", "Economics");
    String userInterest = faker.options().option("Sports", "Reading", "Music");
    String picturePath = "image.png";
    String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String userCity = getRandomCityByState(userState);
    String userBirthYear = String.valueOf(faker.number().numberBetween(1924, 2010));
    String userBirthMonth = RandomUtils.setRandomValue("February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December");
    String userBirthDay = String.valueOf(faker.number().numberBetween(1,28));

    @Test
    void fillFullFormTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubject)
                .setHobby(userInterest)
                .setPicture(picturePath)
                .setCurrentAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userInterest)
                .checkResult("Picture", picturePath)
                .checkResult("Address", userAddress)
                .checkResult("State and City", userState + " " + userCity);

    }

    @Test
    void minimalFormTest(){
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .submit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", userGender);

    }
    @Test
    void invalidNumberTest(){
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(invalidUserNumber)
                .setDateOfBirth(userBirthDay, userBirthMonth, userBirthYear)
                .submit();

        registrationPage.checkNoResults();
    }
}