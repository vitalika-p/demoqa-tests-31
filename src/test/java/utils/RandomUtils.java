package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomAddress());
        System.out.println(getRandomInt(111, 99999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomState());
        System.out.println(getRandomSubject());
        System.out.println(getRandomHobbie());
        System.out.println(getRandomMonth());
        System.out.println(getRandomBirthYear());

    }


    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

    public static String getRandomAddress() {
        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);

    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Maths", "Arts", "Social Studies",
                "Chemistry", "Computer Science", "Commerce",
                "Physics", "Economics"};

        return getRandomItemFromArray(subjects);
    }

    public static String getRandomHobbie() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September", "November", "December"};

        return getRandomItemFromArray(months);
    }

    public static int getRandomBirthYear() {
        Random random = new Random();

        int minYear = 1950;
        int maxYear = LocalDate.now().getYear();
        int birthYear = random.nextInt(maxYear - minYear + 1) + minYear;
        return birthYear;
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(states);
    }

    public static String setRandomValue(String... strings){
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values,strings);
        String item = values.get(faker.number().numberBetween(0, values.size()-1));
        return item;
    }

    public static String getRandomCityByState(String state) {
        Map<String, String[]> citiesByState = new HashMap<>();
        citiesByState.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        citiesByState.put("Uttar Pradesh", new String[]{"Lucknow", "Agra", "Merrut"});
        citiesByState.put("Haryana", new String[]{"Karnal", "Panipat"});
        citiesByState.put("Rajasthan", new String[]{"Jaiselmer", "Jaipur"});

        Random random = new Random();
        int index = random.nextInt(citiesByState.get(state).length);
        return citiesByState.get(state)[index];
    }


}