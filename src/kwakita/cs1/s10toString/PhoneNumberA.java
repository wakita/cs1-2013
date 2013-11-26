package kwakita.cs1.s10toString;

import kwakita.cs1.s09hashcode.PhoneNumber;

/**
 * @author wakita
 * toString メソッドの効果を確かめるために，lecture05.s09hashcode で実装した PhoneNumber? クラスの実装から敢て toString メソッドの定義を削除した例．
 */
class PhoneNumberA implements PhoneNumber {
    @SuppressWarnings("unused")
    private final int areaCode, prefix, number;

    public PhoneNumberA(int a, int p, int n) {
        areaCode = a;
        prefix = p;
        number = n;
    }
}
