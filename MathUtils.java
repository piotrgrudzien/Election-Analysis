package wybory;
/**
 * General math methods
 * @author Piotrek
 *
 */
public class MathUtils {
	/*
	 * Adds two vectors elementwise
	 */
	public static double[] AddVec(double[] Vector1, double[] Vector2) throws Exception {
		if (Vector1.length != Vector2.length) {
			throw new Exception("Vectors have to be of the same length");
		}
		for (int i = 0; i < Vector1.length; i++) {
			Vector1[i] += Vector2[i];
		}
		return Vector1;
	}

	/*
	 * Sums vector elements between firstIndex and lastIndex (inclusive)
	 */
	public static double SumVecElem(double[] Vector, int firstIndex, int lastIndex) {
		double result = 0.0;
		for (int i = firstIndex; i <= lastIndex; i++) {
			result += Vector[i];
		}
		return result;
	}
	
	/*
	 * Sums all vector elements
	 */
	public static double SumVecElem(double[] Vector) {
		double result = 0.0;
		for (int i = 0; i < Vector.length; i++) {
			result += Vector[i];
		}
		return result;
	}

	
	/*
	 * Multiplies Vector by Scalar
	 */
	public static double[] MultVecByNumber(double[] Vector, double Scalar) {
		for(int i = 0; i < Vector.length; i++){
			Vector[i] *= Scalar;
		}
		return Vector;
	}
	/*
	 * Finds correlation coefficient between two vectors. The vectors contain % results
	 */
	public static double CorrCoeff(Election election1, Election election2, int i, int j) throws Exception {
		TwoVectors twoVectors = new TwoVectors(election1, election2, i, j);
		return twoVectors.getCorr();
	}

	public static double Mean(double[] vector) {
		return MathUtils.SumVecElem(vector) / vector.length;
	}

}
