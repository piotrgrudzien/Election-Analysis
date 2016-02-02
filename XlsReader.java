package wybory;
/**
 * Reads election data from xls files
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class XlsReader {
	private String globalName;

	public XlsReader(String globalName) {
		this.globalName = globalName;
	}

	Election readXLS() throws IOException {
		String filePath = "C:\\Users\\Piotrek\\Desktop\\WyboryNew\\DaneAll\\" + this.globalName;
		final File folder = new File(filePath);
		Election result = null;
		for (final File fileEntry : folder.listFiles()) {
			if (result == null) {
				System.out.println("READ ONE FILE");
				result = readOneFile(fileEntry);
			} else {
				System.out.println("ADD WYNIKI");
				result.addWyniki(readOneFile(fileEntry).getWyniki());
			}
		}
		return result;
	}

	Election readOneFile(File fileEntry) throws IOException {
		InputStream is = new FileInputStream(fileEntry);
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		wb.close();
		HSSFRow row;
		HSSFCell cell;

		int rows; // No of rows
		rows = sheet.getPhysicalNumberOfRows();

		int cols = 0; // No of columns
		int tmp = 0;

		// This trick ensures that we get the data properly even if it
		// doesn't start from first few rows
		for (int i = 0; i < 10 || i < rows; i++) {
			row = sheet.getRow(i);
			if (row != null) {
				tmp = sheet.getRow(i).getPhysicalNumberOfCells();
				if (tmp > cols)
					cols = tmp;
			}
		}
		String[] Names = null;
		int[] CandidateIndexes = null, IdIndexes = null;
		switch (this.globalName) {
		case "2000Year":
			Names = Const.Names2000;
			CandidateIndexes = Const.CandidateIndexes2000;
			IdIndexes = Const.IdIndexes2000;
			break;
		case "2005Tura1":
			Names = Const.Names2005Tura1;
			CandidateIndexes = Const.CandidateIndexes2005Tura1;
			IdIndexes = Const.IdIndexes2005Tura1;
			break;
		case "2005Tura2":
			Names = Const.Names2005Tura2;
			CandidateIndexes = Const.CandidateIndexes2005Tura2;
			IdIndexes = Const.IdIndexes2005Tura2;
			break;
		case "2010Tura1":
			Names = Const.Names2010Tura1;
			CandidateIndexes = Const.CandidateIndexes2010Tura1;
			IdIndexes = Const.IdIndexes2010Tura1;
			break;
		case "2010Tura2":
			Names = Const.Names2010Tura2;
			CandidateIndexes = Const.CandidateIndexes2010Tura2;
			IdIndexes = Const.IdIndexes2010Tura2;
			break;
		case "2015Tura1":
			Names = Const.Names2015Tura1;
			CandidateIndexes = Const.CandidateIndexes2015Tura1;
			IdIndexes = Const.IdIndexes2015Tura1;
			break;
		case "2015Tura2":
			Names = Const.Names2015Tura2;
			CandidateIndexes = Const.CandidateIndexes2015Tura2;
			IdIndexes = Const.IdIndexes2015Tura2;
			break;
		case "2001Sejm":
			Names = Const.Names2001Sejm;
			CandidateIndexes = Const.CandidateIndexes2001Sejm;
			IdIndexes = Const.IdIndexes2001Sejm;
			break;
		case "2005Sejm":
			Names = Const.Names2005Sejm;
			CandidateIndexes = Const.CandidateIndexes2005Sejm;
			IdIndexes = Const.IdIndexes2005Sejm;
			break;
		case "2007Sejm":
			Names = Const.Names2007Sejm;
			CandidateIndexes = Const.CandidateIndexes2007Sejm;
			IdIndexes = Const.IdIndexes2007Sejm;
			break;
		case "2011Sejm":
			Names = Const.Names2011Sejm;
			CandidateIndexes = Const.CandidateIndexes2011Sejm;
			IdIndexes = Const.IdIndexes2011Sejm;
			break;
		}
		if (Names.length != CandidateIndexes.length) {
			System.out.println("Names.length != CandidateIndexes.length");
		}

		String Kod = null;

		Map<IdentSet, double[]> Wyniki = new HashMap<IdentSet, double[]>();
		@SuppressWarnings("unused")
		IdentSet identSetPrev = null;
		for (int r = 1; r < rows; r++) {
			// System.out.println("row = " + r);
			double[] Glosy = new double[CandidateIndexes.length];
			row = sheet.getRow(r);
			IdentSet identSet = null;

			int sum = 0;

			for (int c = 0; c < IdIndexes.length; c++) {
				// System.out.println("column = " + IdIndexes[c]);
				if (c == 0) {
					Kod = row.getCell(IdIndexes[c]).toString();
					if(Kod.contains(".")){
						Kod = Kod.substring(0, Kod.length() - 2);
					}
				} else {
					identSet = new IdentSet(Kod, row.getCell(IdIndexes[c]).toString());
				}
				if (Kod.length() != 6) {
					Kod = "0" + Kod;
				}
			}
			for (int c = 0; c < CandidateIndexes.length; c++) {
				cell = row.getCell(CandidateIndexes[c]);
				if (c < CandidateIndexes.length - 1) {
					Glosy[c] = Double.parseDouble(cell.toString());
					sum += Glosy[c];
				} else {
					Glosy[c] = Double.parseDouble(cell.toString()) - sum;
				}
			}
			Wyniki.put(identSet, Glosy);
			identSetPrev = new IdentSet(identSet.getKod(), identSet.getObwod());
		}
		return new Election(Names, Wyniki);
	}
}
