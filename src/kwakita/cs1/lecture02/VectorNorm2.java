package kwakita.cs1.lecture02;

public class VectorNorm2 {
  double ノルム(double[] ベクトル) {
    double 二乗和 = 0.0;
    for (double 要素 : ベクトル) 二乗和 += 要素 * 要素;
    return Math.sqrt(二乗和);
  }
}
