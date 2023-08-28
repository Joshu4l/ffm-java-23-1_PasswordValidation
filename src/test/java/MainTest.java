import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void returnTrue_givenEightOrMoreCharacters () {
        //GIVEN
        String inputPassword = "meinMehrAlsAchtZeichenLangesPasswort";

        //WHEN
        boolean actual = Main.validateLength(inputPassword);

        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnFalse_givenSevenOrLessCharacters () {
        //GIVEN
        String inputPassword = "sieben";

        //WHEN
        boolean actual = Main.validateLength(inputPassword);

        //THEN
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnTrue_givenOneOrMoreNumbersContained () {
        //GIVEN
        String inputPassword = "1ZweiDreiVierFünf";

        //WHEN
        boolean actual = Main.validateNumerics(inputPassword);

        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnFalse_givenNoNumbersContained () {
        //GIVEN
        String inputPassword = "einsZweiDreiVierFünf";

        //WHEN
        boolean actual = Main.validateNumerics(inputPassword);

        //THEN
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnFalse_givenOnlyLowerCase () {
        //GIVEN
        String inputPassword = "abcdefg";

        //WHEN
        boolean actual = Main.validateCaps(inputPassword);

        //THEN
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnTrue_givenAtLeastOneUpperAndLowercase () {
        //GIVEN
        String inputPassword = "Abcdefg";

        //WHEN
        boolean actual = Main.validateCaps(inputPassword);

        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnTrue_givenNoPoorSequence () {
        //GIVEN
        String inputPassword = "meinPasswort";

        //WHEN
        boolean actual = Main.validatePasswordStrength(inputPassword);

        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnFalse_givenPasswordContainingPoorSequence () {
        //GIVEN
        String inputPassword = "mein1234567Passwort";

        //WHEN
        boolean actual = Main.validatePasswordStrength(inputPassword);

        //THEN
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnTrue_givenOneOrMoreSpecialCharacters () {
        //GIVEN
        String inputPassword = "th!sOneContains$pec!alCharacter§";

        //WHEN
        boolean actual = Main.validateSpecialCharacters(inputPassword);

        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnFalse_givenNoSpecialCharacters () {
        //GIVEN
        String inputPassword = "thisOneDoesNot";

        //WHEN
        boolean actual = Main.validateSpecialCharacters(inputPassword);

        //THEN
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

}