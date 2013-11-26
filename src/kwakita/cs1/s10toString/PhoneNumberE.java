package kwakita.cs1.s10toString;

import kwakita.cs1.s09hashcode.PhoneNumber;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @author wakita
 * PhoneNumber クラスの完成
 */
class PhoneNumberE implements PhoneNumber {
    private final int areaCode, prefix, number;

    public PhoneNumberE(int a, int p, int n) {
        areaCode = a;
        prefix = p;
        number = n;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumberE)) return false;
        PhoneNumberE x = (PhoneNumberE) o;
        return x.areaCode == areaCode && x.prefix == prefix
                && x.number == number;
    }

    public int hashCode() {
        int p0 = 21, p = 31;
        return ((p0 + areaCode) * p + prefix) * p + number;
    }
    
    public static PhoneNumberE of(String s) {
        Scanner scan = new Scanner(s);
        scan.next("\\(([0-9]+)\\)([0-9]+)-([0-9]+)");
        MatchResult match = scan.match();
        return new PhoneNumberE(Integer.valueOf(match.group(1)),
                Integer.valueOf(match.group(2)), Integer.valueOf(match.group(3)));
    }
    
    public String toString() {
        return String.format("(%02d)%04d-%04d", areaCode, prefix, number);
    }
}
