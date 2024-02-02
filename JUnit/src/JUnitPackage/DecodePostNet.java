package JUnitPackage;

import java.util.Scanner;
import java.util.HashMap;

/**
 *  Description: Converts the User's binary representation of their zip code to its decimal representation. This is
 *  done through a list of conversions that are given as well as a HashMap to convert each of the binary digits to
 *  their decimal representation.
 */
public class DecodePostNet {
    /**
     *  Holds possible conversions from binary to decimal (0-9)
     */
    public final HashMap<String, Character> hashMapConverter = new HashMap<>();

    /**
     *  Captures the binary representation of the User's zipcode
     * @return the user's input
     */

    public String getUserInput(){
        System.out.print("Please enter PostNet binary code: ");
        Scanner scanUserInput = new Scanner(System.in);
        String postNet = scanUserInput.next();

        return postNet;
    }

    /**
     * Removes the guard bars that are placed for interpretation purposes
     * @param userInput represents the user inputted binary representation of digits
     * @return the binary representation without the guard bars at the beginning and end
     */
    public String removeGuards(String userInput){
        String removedGuard = userInput.substring(1,userInput.length()-1);
        return removedGuard;
    }

    /**
     *  Removes the check digit that is placed at the end of the binary representation
     * @param removedGuards represents the string of binary digits that do not include the guard bars
     * @return the binary digit without the checksum at the end
     */
    public String removeCheckDigit(String removedGuards){
        String removedCheckDigit = removedGuards.substring(0,removedGuards.length()-5);
        return removedCheckDigit;
    }

    /**
     *  Converts each binary number to its decimal representation
     * @param removedCheckDigit represents the binary representation without the check digit
     * @return the decimal representation of the binary digit
     */
    public String convertToDec(String removedCheckDigit){
        String decRep = "";
        hashMapConverter.put("11000",'0');
        hashMapConverter.put("00011",'1');
        hashMapConverter.put("00101",'2');
        hashMapConverter.put("00110",'3');
        hashMapConverter.put("01001",'4'); // Associates each string with each other (value and key)
        hashMapConverter.put("01010",'5');
        hashMapConverter.put("01100",'6');
        hashMapConverter.put("10001",'7');
        hashMapConverter.put("10010",'8');
        hashMapConverter.put("10100",'9');
        for(int i = 0; i < removedCheckDigit.length()-1;i+=5){ // Adds five every time to
            decRep+= hashMapConverter.get(removedCheckDigit.substring(i,i+5));
            // Adds five every time to encapsulate the entire binary digit
        }
        return "Your zipcode (decoded) is: " + decRep;
    }

}
