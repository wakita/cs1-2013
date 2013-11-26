package kwakita.cs1.s10toString;

import org.junit.Assert;
import kwakita.cs1.s09hashcode.PhoneNumber;
import static kwakita.cs1.U.out;

import org.junit.Test;

public class ToStringTest {
    private void test(String expected, PhoneNumber phone) {
        out.printf("    %s: %s\n",
                phone.getClass().getSimpleName(), phone);
        Assert.assertEquals(expected, phone.toString());
    }
    
    @Test
    public void phoneA1() {
        test("(03)1234-5678", new PhoneNumberA(3, 1234, 5678));
    }
    
    @Test
    public void phoneA2() {
        test("(03)0123-0001", new PhoneNumberA(3, 123, 1));
        out.println();
    }
    
    @Test
    public void phoneB1() {
        out.println();
        test("(03)1234-5678", new PhoneNumberB(3, 1234, 5678));
    }
    
    @Test
    public void phoneB2() {
        test("(03)0123-0001", new PhoneNumberB(3, 123, 1));
        out.println();
    }
    
    @Test
    public void phoneC() {
        out.println();
        test("(03)1234-5678", new PhoneNumberC(3, 1234, 5678));
    }
    
    @Test
    public void phoneC2() {
        test("(03)0123-0001", new PhoneNumberC(3, 123, 1));
    }
    
    @Test
    public void phoneC3() {
        test("(03)0123-0001", new PhoneNumberC(03, 0123, 0001));
    }
    
    @Test
    public void zeroNumber() {
        out.println();
        out.printf("    006: %d\n    007: %d\n    010: %d\n    011: %d\n",
                006, 007, 010, 011);
    }
    
    @Test
    public void PhoneNumberD_of() {
        out.println();
        PhoneNumber phone = PhoneNumberD.of("(03)0123-0001");
        test("(03)0123-0001", phone);
    }
}
