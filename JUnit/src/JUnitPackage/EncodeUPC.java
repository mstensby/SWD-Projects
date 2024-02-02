package JUnitPackage;

import java.util.Scanner;
import java.lang.Integer;
import java.lang.String;

/**
 *  Description: Converts a User inputted UPC-A product code into its barcode representation through
 *  a series of conversions. First, the check digit must be calculated because that digit needs to be represented
 *  in the binary representation of the product code. After the check digit is found, the product code is converted
 *  one digit at a time until each digit is converted to their binary representation. The outputted string includes
 *  guard bars as well as the binary representation of the check digit at the end of the binary digits.
 */
public class EncodeUPC {
    /**
     *  Captures the product code that the User wishes to encode
     * @return the user's input
     */
    public String getUserInput(){
        System.out.print("Please enter Product code: ");
        Scanner scanUserInput = new Scanner(System.in);
        String productCode = scanUserInput.next();

        return productCode ;

    }

    /**
     *  Calculates the check digit.
     * @param productCode represents the user inputted product code that is later converted into binary
     * @return the check digit in a form of an int so it can be later used to calculate the binary representation.
     */
    public int getCheckDigit(String productCode){
        int checkDigitOdd = 0;
        int checkDigitEven = 0;
        /*Checks if the binary representation to digit is even or odd, and if it is then that number is added to
         the even or odd total, which is then used to get the check digit used in the product code
         */
       for(int i = 0; i < productCode.length();++i) {
           if (productCode.charAt(i) % 2 == 0) {
               checkDigitEven += Integer.parseInt(String.valueOf(productCode.charAt(i)));
           }
           // gets the character which is the digit itself, converts to a string and then converts the string into an integer
           // this can also be done through finding the character and then subtracting '0'
           else if (Integer.parseInt(String.valueOf(productCode.charAt(i))) % 2 == 1) {
               checkDigitOdd += Integer.parseInt(String.valueOf(productCode.charAt(i)));
           }
       }
       checkDigitOdd*=3;
       int checkDigitTotal = (checkDigitEven+ checkDigitOdd) %10;
       if (checkDigitTotal == 0){
           checkDigitTotal = 0;
       }
       else{
           checkDigitTotal = 10 - checkDigitTotal;
       }
       return checkDigitTotal;
    }

    /**
     *  Takes in the Users product code and converts each decimal to its binary representation
     * @param productCode represents the user inputted product code
     * @param checkDigitTotal represents the check digit that is later converted from decimal to binary
     * @return the converted binary represenation of the product code
     */
    public String numberToEncode(String productCode, int checkDigitTotal){

        String binRepresentation;
        // Associates each binary digit with the index of the array
        String[] arrayOfConversionsLeft = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111",
                "0111011", "0110111", "0001011"};
        String[] arrayOfConversionsRight={"1110010","1100110","1101100", "1000010", "1011100", "1001110", "1010000",
            "1000100","1001000", "1110100"};
        /**
         *  Stores the barcode that was just converted from the product code (Starts and will
         * end with 101 for guard bars)
         */
        binRepresentation = "101";
        for(int i = 0; i < productCode.length(); ++i){
            /* If statements check to see what form of the binary representation should be used since it differs
            depending on whether the digit is less than, equal to, or greater than 6. The binary representation
            is then found through the index, which represents the decimal number that needs to be converted
             */
            // Adds middle guard bar
            if(i == 6){
                binRepresentation+="01010";
            }
            if(i < 6){
                binRepresentation+= arrayOfConversionsLeft[Integer.parseInt(String.valueOf(productCode.charAt(i)))];
                // above comment applies here
            }
            else{
                binRepresentation+= arrayOfConversionsRight[Integer.parseInt(String.valueOf(productCode.charAt(i)))];

            }
        }
        binRepresentation+= arrayOfConversionsRight[checkDigitTotal] + "101";
        return binRepresentation;
    }
}
