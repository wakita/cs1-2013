package kwakita.cs1.s10toString;

import kwakita.cs1.s09hashcode.PhoneNumber;

/**
 * @author wakita
 * PhoneNumberA の出力結果があんまりなので，toString メソッドを追加してみた例．
 * 
 * 0 で始まる市街局番の出力などに問題がある．
 */
class PhoneNumberB implements PhoneNumber {
    private final int areaCode, prefix, number;

    public PhoneNumberB(int a, int p, int n) {
        areaCode = a;
        prefix = p;
        number = n;
    }

    public String toString() {
        return String.format("(%d)%d-%d", areaCode, prefix, number);
    }
}
