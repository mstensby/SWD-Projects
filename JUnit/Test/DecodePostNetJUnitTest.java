import JUnitPackage.DecodePostNet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: Exhaustive unit test casing on the Decoding portion of the POSTNET program. Makes use of testing
 * whether the expected return from each method is the return statement that you would receive from running
 * the program. These tests also check to see when exceptions are thrown due to an invalid input.
 */
public class DecodePostNetJUnitTest {
    DecodePostNet testDecode = new DecodePostNet();

    @Test
    public void testValidGuardsRemoved(){
        String testGuards = testDecode.removeGuards("10101000101001010100100101010101");
        assertEquals("010100010100101010010010101010", testGuards);
    }
    @Test
    public void testValidCheckDigitRemoved(){
        String testCheckDigit = testDecode.removeCheckDigit("010100010100101010010010101010");
        assertEquals("0101000101001010100100101", testCheckDigit);
    }
    @Test
    public void testValidConvertToDec(){
        String testValidConvertor = testDecode.convertToDec("0101000101001010100100101");
        assertEquals("Your zipcode (decoded) is: 52242", testValidConvertor);
    }
    @Test
    public void testInvalidGuardsRemoved(){
        String testInvalidGuard = testDecode.removeGuards("1440");
        assertEquals("44", testInvalidGuard); //Still works like normal
    }
    @Test
    public void testInvalidRemoveCheckDigit(){
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            testDecode.removeCheckDigit("44"); // Index out of bounds error is thrown
        });
    }
    @Test
    public void testInvalidConvertToDec() {
        assertThrows(IndexOutOfBoundsException.class, ()->{
            testDecode.convertToDec("44"); // Index out of bounds error is thrown
        });
    }



}
