package JUnitPackage;

import java.util.Scanner;

/**
 * Description: Takes in the User's zipcode and converts each decimal number to its binary and barcode representation.
 * This is done through finding the associated checksum of the zipcode, and then converting each of the numbers to
 * their binary representation. After this is done, a simple conversion that checks if the binary digit is a 0 or 1
 * helps determine what should be put in place of that for the barcode representation of '.' or '|'.
 */
public class EncodePostNet {
    /**
     * Takes in the User's zipcode
     * @return the user's input
     */
    public String getUserInput(){
        System.out.println("Enter your Zip Code please: ");
        Scanner scanForInput  = new Scanner(System.in);
        String zipcode = scanForInput.next();
        return zipcode;
    }
    /**
     * Calculates the checksum associated with the User's zipcode
     * @param zipcode represents the user inputted zipcode
     * @return the checksum associated with the zipcode
     */
    public int findCheckSum(String zipcode){
        int checksum = 0;
        for(int i = 0; i < zipcode.length(); ++i){
            checksum += Integer.valueOf(zipcode.charAt(i));
        }
        return 10 - (checksum % 10);
    }

    /**
     * Combines the zipcode and associated checksum
     * @param zipcode represents the zipcode that was entered by the user
     * @param checksum represents the associated checksum with the zipcode
     * @return the zipcode and its checksum
     */
    public String totalZipcodeConverter(String zipcode, int checksum){
        String totalZipcode = zipcode + checksum;
        return totalZipcode;
    }
    /**
     * Converts each digit in the User's zipcode to its associated binary representation
     * @param totalZipCode represents the zipcode (including the checksum)
     * @return the zipcode that has been converted into binary
     */
    public String numberToEncode(String totalZipCode){
        String binRepresentation = "";
        // Associates each binary digit with the index of the array
        String[] arrayOfConversions = {"11000", "00011", "00101", "00110", "01001", "01010", "01100",
        "10001", "10010", "10100"};
        System.out.println("The number you wish to convert to binary is: " + totalZipCode);
        binRepresentation = "1";
        for(int i = 0; i < totalZipCode.length(); ++i){
            if(totalZipCode.charAt(i) == '-'){
                continue;
            }
            binRepresentation+= arrayOfConversions[Integer.parseInt(String.valueOf(binRepresentation.charAt(i)))];
        }
        // Goes from character, to string, to integer and then that index is used to find the binary representation
        // that is associated with that specific integer now. Another way this could have been done is a direct
        // conversion between the character and the integer through: arrayOfConversions[totalZipCode.charAt(i) - '0']
        // or binRepresentation+= arrayOfConversions[Integer.valueOf(totalZipCode.charAt(i))];
        binRepresentation+= "1";
        return binRepresentation;
    }
    /**
     *  Converts the binary representation of the zipcode to a barcode-like representation
     * @param binRepresentation represents the final representation of the zipcode in binary.
     * @return the barcode formatted in a way that is readable by a barcode scanner
     */
    public String binaryToBar(String binRepresentation){
        System.out.println("The Binary number to be encoded is: " + binRepresentation);
        String barcodeRepresentation = "";
        for(int i = 0; i < binRepresentation.length(); ++i) {
            if (binRepresentation.charAt(i) != ' ') {
                int valueOfBinRep = Integer.parseInt(String.valueOf(binRepresentation.charAt(i)));
                // the above comment also applies here
                if (valueOfBinRep == 1) {
                    barcodeRepresentation += "|";
                } else if (valueOfBinRep == 0) {
                    barcodeRepresentation += ".";
                } else {
                    System.out.println(valueOfBinRep);
                }
            }
        }
        return barcodeRepresentation;
    }






}
