package JUnitPackage;

public class EncodeUPCDriver {
    public static void main(String args[]){
        EncodeUPC exampleUPC = new EncodeUPC();
        String tmp = exampleUPC.getUserInput();
        int tmp1 = exampleUPC.getCheckDigit(tmp);
        String tmp2 = exampleUPC.numberToEncode(tmp,tmp1);
        System.out.println(tmp2);
    }
}
