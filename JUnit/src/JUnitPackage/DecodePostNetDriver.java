package JUnitPackage;

public class DecodePostNetDriver {
    public static void main(String args[]){
        DecodePostNet myBinRep = new DecodePostNet();
        String userInput = myBinRep.getUserInput();
        String minusGuards = myBinRep.removeGuards(userInput);
        String removedCheckDigit = myBinRep.removeCheckDigit(minusGuards);
        String decRep = myBinRep.convertToDec(removedCheckDigit);
        System.out.println(decRep);

    }
}
