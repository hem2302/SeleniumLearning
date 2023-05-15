package read.excel.data.learning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataLearning {
	public ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream file = new FileInputStream("D:\\SeleniumLearningTestData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		int sheet1 = book.getNumberOfSheets();
		for (int i = 0; i < sheet1; i++) {
			if (book.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = book.getSheetAt(i);
				// identify the testcases by scanning the entire first rows
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// rows is collection of cells
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase")) {
						// after you grab purchase test case row = pull all the data and feed into test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellTypeEnum()==CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}
					}
				}

			}
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		ReadExcelDataLearning d = new ReadExcelDataLearning();
		ArrayList data = d.getData("purchase");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
	}
}
