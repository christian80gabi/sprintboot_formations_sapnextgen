package tn.gov.douane.formations.app.user.functions;

import java.util.Random;

public class GSecurityData {

    public static char[] generateUsername(int length, String matricule, String firstName,
                                           String lastName, String email, String phone) {

        String combinedChars = matricule + firstName + lastName + email + phone ;
        Random random = new Random();
        char[] username = new char[length];

        username[0] = matricule.charAt(random.nextInt(matricule.length()));
        username[1] = email.charAt(random.nextInt(email.length()));
        username[2] = firstName.charAt(random.nextInt(firstName.length()));
        username[3] = phone.charAt(random.nextInt(phone.length()));

        for(int i = 4; i< length ; i++) {
            username[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return username;
    }

    public static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }
}
