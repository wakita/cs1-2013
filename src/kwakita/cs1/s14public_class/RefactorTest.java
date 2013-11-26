package kwakita.cs1.s14public_class;

public class RefactorTest {
    private double x;
    double getX() { return this.x; }
    void setX(double x) { this.x = x; }
    
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    private double y;   
}

class RefactorTestTest {
    RefactorTest rt;
    
    void foo() {
        rt.setY(7.0);
    }
}
