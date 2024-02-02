import JUnitPackage.EncodeUPC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: Exhaustive unit testing to check each of the methods that are used in the EncodeUPC program. Makes sure
 * that each of methods return the desired output from each of them.
 */
public class EncodeUPCJUnitTest {
    EncodeUPC testUPC = new EncodeUPC();
    @Test
    void testIsCorrectCheckDigit(){
        int test1 = testUPC.getCheckDigit("01254667375");
        assertEquals(8, test1);
    }
    @Test
    void testIsCorrectUPCBarcode(){
        String test2 = testUPC.numberToEncode("01254667375",8);
        assertEquals("10100011010011001001001101100010100011010111101010101000010001001000010100010010011101001000101", test2);
    }

    @Test
    void testWrongProductCode(){
        int test3 = testUPC.getCheckDigit("01"); // Tests what happens with the checkDigit
        assertEquals(7, test3);
        String test4 = testUPC.numberToEncode("01", 7); // Tests what happens with the new encoded number
        assertEquals("101000110100110011000100101", test4);
        // Makes sure that the number to encode is outputted properly
        assertFalse(testUPC.numberToEncode("01254667375",8).equals("101"));
        assertFalse(testUPC.numberToEncode("01254667375",8).equals("101000110100110010010011011000101000110101111010101010000100010010000101000100100111010010001011"));
    }



}
