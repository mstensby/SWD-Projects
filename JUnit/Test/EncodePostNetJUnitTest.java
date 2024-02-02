import JUnitPackage.EncodePostNet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Description: This class is an exhaustive test casing class that verifies each of the methods that are used
 * in the EncodePostNet program. This program tests through checking each of the return values of the methods
 * and comparing them to the desired output. Tests are done for invalid inputs as well.
 */
public class EncodePostNetJUnitTest {
    EncodePostNet testEncode = new EncodePostNet();

    @Test
    public void testValidChecksum() {
        int testProperChecksum = testEncode.findCheckSum("52242");
        assertEquals(5, testProperChecksum);
    }
    @Test
    public void testValidZip(){
        String testProperTotalZipConverter = testEncode.totalZipcodeConverter("52242", 5);
        assertEquals("522425", testProperTotalZipConverter);
        }
        @Test
    public void testValidBinary(){
        String testProperBinaryRep = testEncode.numberToEncode("522425");
        assertEquals("10101000101001010100100101010101", testProperBinaryRep);
    }
    @Test
    public void testValidEncode(){
        String testProperEncoding = testEncode.binaryToBar("10101000101001010100100101010101");
        assertEquals("|.|.|...|.|..|.|.|..|..|.|.|.|.|", testProperEncoding);
    }
    @Test
    public void testInvalidChecksum() {
        int testCheckSumFinder = testEncode.findCheckSum("45");
        assertEquals(5, testCheckSumFinder); // Still calculates properly
    }
    @Test
    public void testInvalidZip(){
        String testZipConverter = testEncode.totalZipcodeConverter("45", 5);
        assertEquals("455",testZipConverter); // Converted to string properly
    }
    @Test
    public void testInvalidBinaryRep(){
        String testForBinary = testEncode.numberToEncode("455");
        assertEquals("10100101010010101", testForBinary); // converted improper zipcode correctly
    }
    @Test
    public void testInvalidBarcodeRep(){
        String testForBarRep = testEncode.binaryToBar("10100101010010101");
        assertEquals("|.|..|.|.|..|.|.|", testForBarRep); // binary representation converted correctly
    }
}

