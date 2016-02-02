package wybory;

import java.io.FileWriter;
import java.util.Arrays;

import com.opencsv.CSVWriter;

public class wyboryRun {
	public static void main(String[] args) throws Exception {
		XlsReader xlsReader1 = new XlsReader(Elections.TuraI2005);
		Election election1 = xlsReader1.readXLS();
		XlsReader xlsReader2 = new XlsReader(Elections.TuraII2005);
		Election election2 = xlsReader2.readXLS();
		// System.out.println(Arrays.toString(election.getNames()));
		//System.out.println("Frekwencja: " + election1.getTotalFrekwencja());
		//System.out.println("Wyniki: " +
		//Arrays.toString(election2.getTotalWynikiProcentReal()));
		// System.out.println(MathUtils.SumVecElem(election1.getTotalWynikiProcent()));
		// System.out.println("Liczba uprawnionych: " +
		// MathUtils.SumVecElem(election.getTotalWyniki()));
		// System.out.println("Wazne glosy: " +
		// MathUtils.SumVecElem(election.getTotalWyniki(), 0,
		// election.getTotalWyniki().length - 3));
		// System.out.println("Niewazne glosy: " +
		// election.getTotalWyniki()[election.getTotalWyniki().length - 2]);
		// election1.IdentSetOverlapReport(election2);
		//election1.giveXY(4, 10);
		
		String FileName = "CrossCorrelationITuraIITura.csv";
		outputCorrelation(election1, election2, FileName);
		//outputWynikiProcentReal(election2, FileName);
	}

	private static void outputWynikiProcentReal(Election election, String fileName) throws Exception {
		CSVWriter writer = new CSVWriter(new FileWriter(fileName), '\t');
		writer.writeNext(election.getNames());
		String[] insertRow = new String[election.getNames().length - 2];
		for (int i = 0; i < election.getNames().length - 2; i++) {
			insertRow[i] = String.valueOf(election.getTotalWynikiProcentReal()[i]);
		}
		writer.writeNext(insertRow);
		writer.close();
		System.out.println("Wyniki successfully written to CSV file");
	}

	private static void outputCorrelation(Election e1, Election e2, String fileName) throws Exception {
		CSVWriter writer = new CSVWriter(new FileWriter(fileName), '\t');
		writer.writeNext(e1.getNames());
		writer.writeNext(e2.getNames());
		int longer = e1.getNames().length > e2.getNames().length ? e1.getNames().length - 2 : e2.getNames().length - 2;
		String[] insertRow = new String[longer];
		for (int i = 0; i < e1.getNames().length - 2; i++) {
			for (int j = 0; j < e2.getNames().length - 2; j++) {
				insertRow[j] = String.valueOf(MathUtils.CorrCoeff(e1, e2, i, j));
				//System.out.println("Correlation between " + i + " and " + j + ": " + String.valueOf(MathUtils.CorrCoeff(e1, e2, i, j)));
			}
			System.out.println(Arrays.toString(insertRow));
			writer.writeNext(insertRow);
		}
		writer.close();
		System.out.println("Correlation successfully written to CSV file");
	}
}
