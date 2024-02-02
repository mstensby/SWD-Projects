import JUnitPackage.DecodeUPC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: Exhaustive Unit testing through asserting whether the desired method return is equal to the method return
 * that is given through the DecodeUPC program. These tests include testing for invalid inputs that throw an Index error
 */
public class DecodeUPCJUnitTest {
    DecodeUPC myDigits = new DecodeUPC();
    @Test
    void testCorrectProductCode(){
        String test1 = myDigits.inputToDecode("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101");
        assertEquals("Check digit: 4 -OK\nProduct code- 01254667375", test1);

        // Put in inputs that are wrong, but it should still work minimally
    }
    @Test
    void testIsTooShort(){

        assertThrows(IndexOutOfBoundsException.class, ()->{ // Throws an index out of bounds exception since there are not enough inputs
            myDigits.inputToDecode("01");
        });

    }
    @Test
    void testIsTooLong(){
        assertThrows(IndexOutOfBoundsException.class, ()->{ // Throws an index out of bounds exception since there are too many inputs
            myDigits.inputToDecode("101000110100110010010011011000101000110101111010101010000100010010000101000100100111010111001011");
        });
    }
    @Test
    void testWrongProductCode(){
        assertFalse(myDigits.inputToDecode("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101").equals("Check digit: 4 -OK\nProduct code- 01234123412341234"));
        assertFalse(myDigits.inputToDecode("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101").equals("Check digit: 4 -OK\nProduct code- 0"));
        // Below is the correct input to show that this works
        assertTrue(myDigits.inputToDecode("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101").equals("Check digit: 4 -OK\nProduct code- 01254667375"));
    }
    @Test
    void testWrongCheckDigit(){
        assertFalse(myDigits.inputToDecode("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101").equals("Check digit: 6 -OK\nProduct code- 01254667375"));
        assertFalse(myDigits.inputToDecode("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101").equals("Check digit: 01254667375 -OK\nProduct code- 01254667375"));
        // Below is the correct input to show that this works
        assertTrue(myDigits.inputToDecode("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101").equals("Check digit: 4 -OK\nProduct code- 01254667375"));

    }

}
