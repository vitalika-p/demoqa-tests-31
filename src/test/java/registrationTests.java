import org.junit.jupiter.api.Test;
import pages.registrationPage;

public class registrationTests extends testBase {

    pages.registrationPage registrationPage = new registrationPage();

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUserEmail("ivanov@email.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("17", "December","1989")
                .setSubject("Biology")
                .setHobby("Reading")
                .setPicture("image.png")
                .setCurrentAddress("Tverskaya,100")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        registrationPage
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivanov@email.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "17 December,1989")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "image.png")
                .checkResult("Address", "Tverskaya,100")
                .checkResult("State and City", "NCR Delhi");

    }

}