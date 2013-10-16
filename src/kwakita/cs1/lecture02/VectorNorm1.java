package kwakita.cs1.lecture02;

public class VectorNorm1 {
  double norm(double[] vector) {
    double meanSquare = 0.0;
    for (double x : vector) meanSquare += x * x;
    return Math.sqrt(meanSquare);
  }
}
