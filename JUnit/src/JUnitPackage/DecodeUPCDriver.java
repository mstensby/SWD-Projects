package JUnitPackage;

public class DecodeUPCDriver {
    public static void main(String args[]){
        DecodeUPC myDigits = new DecodeUPC();
        String tmp = myDigits.getUserInput();
        String tmp1 = myDigits.inputToDecode(tmp);
        System.out.println(tmp1);
    }
}
