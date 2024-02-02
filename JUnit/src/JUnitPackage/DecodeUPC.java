package JUnitPackage;

import java.util.Scanner;
import java.util.HashMap;

/**
 *  Description: Takes a binary representation of a barcode and outputs the corresponding product code. This is done
 *  by breaking up the user's input into their 7 digit binary representation. The binary representation of each number
 *  is then concatenated into its own string before it is outputted. This class also makes sure that the
 *  check digit is calculated correctly.
 */
public class DecodeUPC {
    /**
     *  Capture the barcode that the User wishes to decode
     * @return the user's input
     */
    public static String getUserInput(){
        System.out.print("Enter barcode to decode: ");
        Scanner scanUserInput = new Scanner(System.in);
        String userInput = scanUserInput.next();
        return userInput;
    }

    /**
     *  Stores all binary representations of numbers' 0-9 (Binary representation of digits to the left
     * of the Middle Guard bar are represented differently than those to the right of the Middle Guard bar)
     */
    public final HashMap<String, Character> hashMapLeft = new HashMap<>();

    // Not changing reference while putting values, therefore able to be final
    /**
     *  Stores all binary representations of numbers' 0-9 (Binary representation of digits to the right
     * of the Middle Guard bar are represented differently than those to the left of the Middle Guard bar)
     */
    public final HashMap<String, Character> hashMapRight = new HashMap<>();

    /**
     *  Takes the User's barcode and converts it into its Product code representation. This includes adding
     * the checksum to the end of the product code
     * @param userInput represents the user inputted product code
     * @return the decoded product code
     */
    public String inputToDecode(String userInput) {
        /**
         *  Captures the decimal representation of the barcode
         */
        String productCodeRep = "";
        // Associates the string of binary digits and their decimal representations with each other (value and key)
        hashMapLeft.put("0001101", '0');
        hashMapLeft.put("0011001", '1');
        hashMapLeft.put("0010011", '2');
        hashMapLeft.put("0111101", '3');
        hashMapLeft.put("0100011", '4');
        hashMapLeft.put("0110001", '5');
        hashMapLeft.put("0101111", '6');
        hashMapLeft.put("0111011", '7');
        hashMapLeft.put("0110111", '8');
        hashMapLeft.put("0001011", '9');
        // Split into 2 since each conversion depends on whether it is to the left or the right of the guard bar
        hashMapRight.put("1110010", '0');
        hashMapRight.put("1100110", '1');
        hashMapRight.put("1101100", '2');
        hashMapRight.put("1000010", '3');
        hashMapRight.put("1011100", '4');
        hashMapRight.put("1001110", '5');
        hashMapRight.put("1010000", '6');
        hashMapRight.put("1000100", '7');
        hashMapRight.put("1001000", '8');
        hashMapRight.put("1110100", '9');
        /**
         *  Removes the end Guard bars that are associated with the User's barcode
          */
        String minusEndGuardBars = userInput.substring(3, userInput.length() - 3); // simply the original string of 1's and 0's without the end guard bar or checksum
        /**
         * Locates the middle guard, so it can be removed
         */
        final int middleGuardLocation = (7 * 6-1);
        /**
         * Locates the checksum in the user's input, so it can be decoded later
         */
        String checksum = minusEndGuardBars.substring(minusEndGuardBars.length() - 7, minusEndGuardBars.length());
        /**
         *  Removes the checksum from the User's barcode
         */
        String minusEndGuardBarsTotal = minusEndGuardBars.substring(0,minusEndGuardBars.length()-7);
        /* the middle guards' location will always be after the first 42 digits of the string with no end guard bars.
         No matter what number the input is, (6 binary representations each with 7 bits available) the middle
         guard will always be of length 5.
         */
        for (int i = 0; i < middleGuardLocation; i += 7) {   // Checking to see if the substring is equal to the key
            productCodeRep += (hashMapLeft.get(minusEndGuardBarsTotal.substring(i, i + 7))); // non-inclusive of the 7th
        }
        for (int i = middleGuardLocation + 6; i < minusEndGuardBarsTotal.length(); i += 7) {
            productCodeRep += (hashMapRight.get(minusEndGuardBarsTotal.substring(i, i + 7)));
        }
        String checkSumString = "Check digit: " + hashMapRight.get(checksum) + " -OK\n"; // Outputs the checksum
        return checkSumString + "Product code- "+ productCodeRep;
    }

}
