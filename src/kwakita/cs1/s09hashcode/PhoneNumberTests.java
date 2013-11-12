package kwakita.cs1.s09hashcode;

import static kwakita.cs1.U.err;
import static kwakita.cs1.U.hashSet;
import static kwakita.cs1.U.out;

import java.util.Set;

// import junit.framework.Assert;
import org.junit.Assert;
import kwakita.cs1.U;

import org.junit.Test;

/**
 * @author wakita
 *
 * PhoneNumber クラスたちの実装の違いを学ぶための単体テスト群
 */
public class PhoneNumberTests {
    private PhoneNumber[] phones1() {
        return new PhoneNumber[] { new PhoneNumber1(3, 5734, 3493),  new PhoneNumber1(03, 5734, 3493) };
    }
    private PhoneNumber[] phones2() {
        return new PhoneNumber[] { new PhoneNumber2(3, 5734, 3493),  new PhoneNumber2(03, 5734, 3493) };
    }
    private PhoneNumber[] phones3() {
        return new PhoneNumber[] { new PhoneNumber3(3, 5734, 3493),  new PhoneNumber3(03, 5734, 3493) };
    }
    private PhoneNumber[] phones4() {
        return new PhoneNumber[] { new PhoneNumber4(3, 5734, 3493),  new PhoneNumber4(03, 5734, 3493) };
    }

    private void equalityTest(PhoneNumber[] phones) {
        out.printf("\n等価性に関するテスト [%s]\n",
                phones[0].getClass().getSimpleName());
        out.flush();
        Assert.assertEquals(phones[0], phones[1]);
        out.flush();
    }

    @Test
    public void equality1() { equalityTest(phones1()); }
    @Test
    public void equality2() { equalityTest(phones2()); }
    @Test
    public void equality3() { equalityTest(phones3()); }
    @Test
    public void equality4() { equalityTest(phones4()); }
    
    private void hashCodeTest(PhoneNumber[] phones) {
        out.printf("\nハッシュ関数に関するテスト [%s]\n", phones[0].getClass().getSimpleName());
        out.printf("phone1: %d, phone2: %d\n", phones[0].hashCode(), phones[1].hashCode());
        out.flush();
        Assert.assertTrue(
                !phones[0].equals(phones[1]) ||
                phones[0].hashCode() == phones[1].hashCode());
    }
    
    @Test
    public void hashCodeTest1() { hashCodeTest(phones1()); }
    @Test
    public void hashCodeTest2() { hashCodeTest(phones2()); }
    @Test
    public void hashCodeTest3() { hashCodeTest(phones3()); }
    @Test
    public void hashCodeTest4() { hashCodeTest(phones4()); }
    
    private void print(Set<PhoneNumber> 電話帳) {
        out.printf("電話帳: %s\n", java.util.Arrays.toString(電話帳.toArray()));
    }
    
    /**
     * @param phones
     */
    private void 電話帳その1(PhoneNumber[] phones) {
        try {
            PhoneNumber phone1 = phones[0], phone2 = phones[1];
            out.printf("\nHashSet を用いて作成した電話帳を使ったテスト (1) [%s]\n", phones[0].getClass().getSimpleName());
            out.flush();
            
            Set<PhoneNumber> 電話帳 = hashSet();
            /*
             *  【考察：難度高】
             *  
             *  PhoneNumber1 において「電話帳.contains(phone1)」が失敗する．
             *  ここでの失敗は，テストの失敗ではなく contains メソッドが NullPointerException 例外を投げることに原因がある．
             *  なぜ，これらの場合 HashSet (電話帳) は例外を発生するのだろうか．
             */
            Assert.assertFalse(電話帳.contains(phone1));
            Assert.assertFalse(電話帳.contains(phone2));
            print(電話帳);
            
            電話帳.add(phone1);
            Assert.assertTrue(電話帳.contains(phone1));
            Assert.assertNotNull(電話帳);
            Assert.assertNotNull(phone1);
            Assert.assertNotNull(phone2);
            /*
             *  【考察：難度高】
             *  
             *  PhoneNumber2, PhoneNumber3 において上のテストは通るが，「電話帳.contains(phone2)」を実行すると失敗する．
             *  ここでの失敗は，テストの失敗ではなく contains メソッドが NullPointerException 例外を投げることに原因がある．
             *  なぜ，HashSet (電話帳) は例外を発生するのだろうか．
             *  ちなみに電話帳，phone1，phone2がいずれもnullでないことは直前の三つのテストで確認ずみ．
             */
            Assert.assertTrue(電話帳.contains(phone2));
            print(電話帳);
            
            電話帳.add(phone2);
            Assert.assertTrue(電話帳.contains(phone1));
            Assert.assertTrue(電話帳.contains(phone2));
            print(電話帳);
            
            out.println(); out.flush();
        } catch (Error e) {
            err.printf("エラーが発生したのでテストの途中で中断します．\n  [%s]\n", e); err.flush();
            throw e;
        }
    }

    @Test
    public void 電話帳その1_1() { 電話帳その1(phones1()); }
    @Test
    public void 電話帳その1_2() { 電話帳その1(phones2()); }
    @Test
    public void 電話帳その1_3() { 電話帳その1(phones3()); }
    @Test
    public void 電話帳その1_4() { 電話帳その1(phones4()); }
    
    /**
     * @param phones
     * 
     * 電話帳に二つの同一の電話番号を追加し，要素数が1となることを確認するテスト．
     * 電話帳は集合として実装しているので，結果は1になって欲しいが，PhoneNumber[123]では2になってしまう．
     * Eclipse の出力結果 (Console) を見ると，集合の内容が表示されている．
     */
    private void 電話帳その2(PhoneNumber[] phones) {
        out.printf("\nHashSet を用いて作成した電話帳を使ったテスト (2) [%s]\n",
                phones[0].getClass().getSimpleName());
        out.flush();
        Set<PhoneNumber> 電話帳 = hashSet();
        電話帳.add(phones[0]);
        電話帳.add(phones[1]);
        print(電話帳);
        Assert.assertEquals(1, 電話帳.size());
    }
    
    @Test
    public void 電話帳その2_1() { 電話帳その2(phones1()); }
    @Test
    public void 電話帳その2_2() { 電話帳その2(phones2()); }
    @Test
    public void 電話帳その2_3() { 電話帳その2(phones3()); }
    @Test
    public void 電話帳その2_4() { 電話帳その2(phones4()); }
    
    private void performance4() {
        out.println("PhoneNumber4 を用いた性能試験");
        Set<PhoneNumber> 電話帳 = hashSet();
        U.timerStart();
        for (int prefix = 0; prefix < 5; prefix++) {
            for (int areaCode = 0; areaCode < 10000; areaCode++) {
                電話帳.add(new PhoneNumber4(03, prefix, areaCode));
            }
            long t = U.timerStop();
            out.printf("03-%04d-9999: %s%sms\n", prefix,
                    t < 1000 ? "" : "" + t / 1000 + "s ", t % 1000);
        }
        out.println();
    }
    
    private void performance5() {
        out.println("PhoneNumber5 を用いた性能試験");
        Set<PhoneNumber> 電話帳 = hashSet();
        U.timerStart();
        for (int prefix = 0; prefix < 5; prefix++) {
            for (int areaCode = 0; areaCode < 10000; areaCode++) {
                電話帳.add(new PhoneNumber5(03, prefix, areaCode));
            }
            long t = U.timerStop();
            out.printf("03-%04d-9999: %s%sms\n", prefix,
                    t < 1000 ? "" : "" + t / 1000 + "s ", t % 1000);
        }
        out.println();
    }
    
    private void performance6() {
        out.println("PhoneNumber6 を用いた性能試験");
        Set<PhoneNumber> 電話帳 = hashSet();
        U.timerStart();
        for (int prefix = 0; prefix < 5; prefix++) {
            for (int areaCode = 0; areaCode < 10000; areaCode++) {
                電話帳.add(new PhoneNumber6(03, prefix, areaCode));
            }
            long t = U.timerStop();
            out.printf("03-%04d-9999: %s%sms\n", prefix,
                    t < 1000 ? "" : "" + t / 1000 + "s ", t % 1000);
        }
        out.println();
    }
    
    @Test
    public void performance() {
        performance4();
        performance5();
        performance6();
    }
}
