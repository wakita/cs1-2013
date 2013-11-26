package kwakita.cs1.s10toString;

import kwakita.cs1.s09hashcode.PhoneNumber;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @author wakita
 * toString の出力に併せて of メソッドを追加．
 */
class PhoneNumberD implements PhoneNumber {
    private final int areaCode, prefix, number;

    public PhoneNumberD(int a, int p, int n) {
        areaCode = a;
        prefix = p;
        number = n;
    }
    
    public static PhoneNumberD of(String s) {
        Scanner scan = new Scanner(s);
        scan.next("\\(([0-9]+)\\)([0-9]+)-([0-9]+)");
        MatchResult match = scan.match();
        return new PhoneNumberD(Integer.valueOf(match.group(1)),
                Integer.valueOf(match.group(2)), Integer.valueOf(match.group(3)));
    }
    
    public String toString() {
        return String.format("(%02d)%04d-%04d", areaCode, prefix, number);
    }
}
