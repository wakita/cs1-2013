package kwakita.cs1.lecture02;

public class VectorNorm0 {
	double norm(double[] vector) {
		double sum = 0.0;
		for (int i = 0; i < vector.length; i++) {
			sum += vector[i]*vector[i];
		}
		return Math.sqrt(sum);
	}
}
