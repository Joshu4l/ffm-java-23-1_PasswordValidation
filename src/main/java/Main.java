// ARBEITSANWEISUNG:
// Schreibe eine Passwortvalidierung in Java. Erstelle dazu ein neues Java GitHub-Projekt.

//DONE Schritt 1: Lege dir ein neues Java GitHub-Projekt an.
// Schritt 2: Überlege dir, wie die Methoden für die Passwortvalidierung aussehen müssen.
// Schritt 3: Schreibe einen Test für die Passwortlänge.
// Schritt 4: Implementiere die Funktionalität zur Überprüfung der Passwortlänge.
// Schritt 5: Schreibe einen Test für die Überprüfung, ob das Passwort Zahlen enthält.
// Schritt 6: Implementiere die Funktionalität zur Überprüfung, ob das Passwort Zahlen enthält.
// Schritt 7: (Bonus) Schreibe einen Test für die Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
// Schritt 8: (Bonus) Implementiere die Funktionalität zur Überprüfung, ob das Passwort kleine/große Buchstaben enthält.
// Schritt 9: (Bonus) Schreibe einen Test für die Überprüfung, ob das Passwort 'schlechte' Passwörter wie 'passwort' oder '123456' enthält.
// Schritt 10: (Bonus) Implementiere die Funktionalität zur Überprüfung, ob das Passwort 'schlechte' Passwörter enthält.


import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        System.out.println(validatePasswordOverall("Da$Hi3rI§t3inVal!d3sPassw0rt"));

    }

    public static boolean validatePasswordOverall(String inputString) {
        boolean[] validationResults = new boolean[5];
        validationResults[0] = validateLength(inputString);
        validationResults[1] = validateNumerics(inputString);
        validationResults[2] = validateCaps(inputString);
        validationResults[3] = validatePasswordStrength(inputString);
        validationResults[4] = validateSpecialCharacters(inputString);

        int requiredAmountOfTrueValidations = 5;
        int actualAmountOfTrueValidations = 0;

        for (boolean element: validationResults) {
            if (element == true) {
                actualAmountOfTrueValidations +=1;
            } else {
                continue;
            }
        } return requiredAmountOfTrueValidations == actualAmountOfTrueValidations;
    }

    public static String[] splitString(String inputString) {
        return inputString.split("");
    }

    // Passwortlänge?
    public static boolean validateLength(String inputPassword) {

        int minimumLength = 8;
        boolean lengthValidator;
        lengthValidator = splitString(inputPassword).length >= minimumLength;
        return lengthValidator;
    }

    // Zahlen enthalten?
    public static boolean validateNumerics (String inputPassword) {

        int numCounter = 0;
        boolean numericValidator;
        for (String element: splitString(inputPassword)) {
            try {
                Double.parseDouble(element);
                numCounter += 1;
            } catch (NumberFormatException e) {
                continue;
            }
        } numericValidator = numCounter > 0;
        return numericValidator;
    }

    // Groß-/Kleinschreibung
    public static boolean validateCaps (String inputPassword) {

        boolean capsValidator;
        int lowerCounter = 0;
        int upperCounter = 0;
        for (String element : splitString(inputPassword)) {
            char character = element.charAt(0);
            if (Character.isLetter(character)) {
                if (Character.isLowerCase(character)) {
                    lowerCounter++;
                } else if (Character.isUpperCase(character)) {
                    upperCounter++;
                }
            }
        } capsValidator = lowerCounter > 0 && upperCounter > 0;
        return capsValidator;
    }

    // Schlechte Passwörter
    public static boolean validatePasswordStrength (String inputPassword) {

        boolean passwordStrengthValidator = false;
        String[] poorPasswords = {"admin", "passwort", "123456"};

        for (int i = 0; i < poorPasswords.length; i++) {
            if ( inputPassword.toLowerCase().contains(poorPasswords[i]) ) {
                passwordStrengthValidator = false;
            } else {
                passwordStrengthValidator = true;
            }
        } return passwordStrengthValidator;
    }

    // (Sonderzeichen)
    public static boolean validateSpecialCharacters (String inputPassword) {

        int specialCounter = 0;
        String[] specialCharacters = {"?","!","$","§","@","%","/","(",")","*","#","*","+","-","_","<",">"};

        for (int i = 0; i < specialCharacters.length; i++) {
            if ( inputPassword.contains(specialCharacters[i]) ) {
                specialCounter +=1;
            } else {
                continue;
            }
        } return specialCounter > 0;
    }

}