package JUnitPackage;

public class EncodePostNetDriver {
    public static void main(String[] args) {
        EncodePostNet myZipcode = new EncodePostNet();
        String tmp = myZipcode.getUserInput();
        int tmp1 = myZipcode.findCheckSum(tmp);
        String tmp2 = myZipcode.totalZipcodeConverter(tmp, tmp1);
        System.out.println(tmp2);
        String tmp3 = myZipcode.numberToEncode(tmp2);
        String tmp4 = myZipcode.binaryToBar(tmp3);
        System.out.println(tmp4);
    }
}