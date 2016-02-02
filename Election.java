package wybory;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
/**
 * Represents an election
 * @author Piotrek
 *
 */
public class Election {
	private String[] Names;
	private Map<IdentSet, double[]> Wyniki;

	public Election(String[] Names, Map<IdentSet, double[]> Wyniki) {
		this.Names = Names;
		this.Wyniki = Wyniki;
	}

	public String[] getNames() {
		return this.Names;
	}

	public Map<IdentSet, double[]> getWyniki() {
		return this.Wyniki;
	}

	public void addWyniki(Map<IdentSet, double[]> Wyniki) {
		this.Wyniki.putAll(Wyniki);
	}

	public String printRandomSample() {

		Random random = new Random();
		ArrayList<IdentSet> keys = new ArrayList<IdentSet>();
		keys.addAll(this.Wyniki.keySet());
		IdentSet randomKey = keys.get(random.nextInt(keys.size()));
		double[] value = this.Wyniki.get(randomKey);
		return randomKey.toString() + " = " + Arrays.toString(value);
	}

	public double getTotalFrekwencja() throws Exception {
		double[] Total = getTotalWyniki();
		return 100.0 * MathUtils.SumVecElem(Total, 0, Total.length - 2) / MathUtils.SumVecElem(Total);
	}

	public double[] getTotalWyniki() throws Exception {
		double[] Total = new double[this.Names.length];
		for (int i = 0; i < this.Names.length; i++) {
			Total[i] = 0.0;
		}
		for (Entry<IdentSet, double[]> entry : this.Wyniki.entrySet()) {
			double[] Incr = entry.getValue();
			if (Incr.length != this.Names.length) {
				throw new Exception("INCORRECT Wyniki LENGTH at " + entry.getKey().toString());
			}
			Total = MathUtils.AddVec(Total, Incr);
		}
		return Total;
	}

	public double[] getTotalWynikiProcent() throws Exception {
		double[] Total = getTotalWyniki();
		return MathUtils.MultVecByNumber(Total, 100.0 / MathUtils.SumVecElem(Total));
	}

	/*
	 * Pomijajac frekwencje (wyniki takie jak w telewizji)
	 */
	public double[] getTotalWynikiProcentReal() throws Exception {
		double[] Total = getTotalWyniki();
		double[] TotalReduced = new double[Total.length - 2];
		for (int i = 0; i < TotalReduced.length; i++) {
			TotalReduced[i] = Total[i];
		}
		return MathUtils.MultVecByNumber(TotalReduced, 100.0 / MathUtils.SumVecElem(TotalReduced));
	}

	public void IdentSetOverlapReport(Election election2) {
		System.out.println("Pierwszy ma " + this.Wyniki.size() + " obwody");
		System.out.println("Drugi ma " + election2.getWyniki().size() + " obwody");
		int OverlapCounter = 0;
		for (Entry<IdentSet, double[]> entry : this.Wyniki.entrySet()) {
			if (election2.getWyniki().containsKey(entry.getKey())) {
				OverlapCounter++;
			} else {
				//System.out.println("Nonoverlap: " + entry.getKey().toString());
			}
		}
		System.out.println("Overlap obwody: " + OverlapCounter);
		double ProcentPierwszego = 100 * OverlapCounter / this.Wyniki.size();
		System.out.println("Procent pierwszego: " + ProcentPierwszego + "%");
		double ProcentDrugiego = 100 * OverlapCounter / election2.getWyniki().size();
		System.out.println("Procent drugiego: " + ProcentDrugiego + "%");
	}
	
	public int getOverlap(Election election) {
		int OverlapCounter = 0;
		for (Entry<IdentSet, double[]> entry : this.Wyniki.entrySet()) {
			if (election.getWyniki().containsKey(entry.getKey())) {
				OverlapCounter++;
			} 
		}
		return OverlapCounter;
	}

	public void giveXY(int x, int y) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("C:\\Users\\Piotrek\\Desktop\\WyboryNew\\data.csv", "UTF-8");
		for (Entry<IdentSet, double[]> entry : this.Wyniki.entrySet()) {
			double[] Full = entry.getValue(); //includes BrakGlosu
			double[] Reduced = new double[Full.length - 2]; //doesn't include BrakGlosu
			for (int i = 0; i < Reduced.length; i++) {
				Reduced[i] = Full[i];
			}
			writer.print(100.0 * Reduced[x] / MathUtils.SumVecElem(Reduced));
			writer.print(", ");
			writer.println(100.0 * Reduced[y] / MathUtils.SumVecElem(Reduced));
		}
		writer.close();
	}
}
