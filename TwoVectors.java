package wybory;
import java.util.Map.Entry;

public class TwoVectors {
	private double[] x;
	private double[] y;

	public TwoVectors(Election election1, Election election2, int xIndex, int yIndex) throws Exception {
		// In the constructor I'm getting two vectors of results (z pominieciem frekwencji)
		int Overlap = election1.getOverlap(election2);
		this.x = new double[Overlap];
		this.y = new double[Overlap];
		int index = 0;
		for (Entry<IdentSet, double[]> entry : election1.getWyniki().entrySet()) {
			if (election2.getWyniki().containsKey(entry.getKey())) {
				// we want % results (z pominieciem frekwencji), zeby uwzglednic
				// frekwencje - dziel przez cala sume!!!
				if (entry.getValue()[xIndex] == 0) {
					x[index] = 0.0;
				} else {
					x[index] = 100 * entry.getValue()[xIndex] / MathUtils.SumVecElem(entry.getValue(), 0, entry.getValue().length - 3);
				}
				if (election2.getWyniki().get(entry.getKey())[yIndex] == 0) {
					y[index] = 0.0;
				} else {
					y[index] = 100
							* election2.getWyniki().get(entry.getKey())[yIndex]
							/ MathUtils.SumVecElem(election2.getWyniki().get(entry.getKey()), 0,
									election2.getWyniki().get(entry.getKey()).length - 3);
				}
				index++;
			}
		}
		if (x.length != y.length) {
			throw new Exception("x and y has to be the same length");
		}
	}

	public double getCorr() {
		// Zwraca korelacje miedzy dwoma wektorami zbudowanymi w konstruktorze
		double xMean = MathUtils.Mean(x);
		double yMean = MathUtils.Mean(y);
		double prodSum = 0.0;
		double xSq = 0.0;
		double ySq = 0.0;
		for (int i = 0; i < x.length; i++) {
			prodSum += (x[i] - xMean) * (y[i] - yMean);
			xSq += (x[i] - xMean) * (x[i] - xMean);
			ySq += (y[i] - yMean) * (y[i] - yMean);
		}
		return prodSum / (Math.sqrt(xSq * ySq));
	}

}
