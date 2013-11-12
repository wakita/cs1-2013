package kwakita.cs1.s08equals;

import static kwakita.cs1.s08equals.EqualityTests.*;

public class ColorPointTest3 {
    enum Color {
        RED, GREEN, BLUE
    };

    class Point {
        protected final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }

        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    class ColorPoint {
        private Point       p;
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            if (color == null) throw new NullPointerException();
            p = new Point(x, y);
            this.color = color;
        }

        public Point asPoint() {
            return p;
        }

        public boolean equals(Object o) {
            if (!(o instanceof ColorPoint)) return false;
            ColorPoint cp = (ColorPoint) o;
            return cp.p.equals(p) && cp.color.equals(color);
        }

        public String toString() {
            return String.format("%s(%d, %d)", color, p.x, p.y);
        }
    }

    private void run() {
        Point p = new Point(1, 2);
        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED), cp2 = new ColorPoint(
                1, 2, Color.BLUE);
        reflexivity(p);
        reflexivity(cp1);
        symmetry(p, cp1);
        transitivity(p, cp1, cp2);
    }

    public static void main(String[] _) {
        new ColorPointTest3().run();
    }
}
