package read.excel.data.learning;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataproviderLearning {

	@Test(dataProvider = "driveTest")
	public void getData(String name, String message, String id) {
		System.out.println(name + " " + message + " " + id);

	}

	@DataProvider(name = "driveTest")
	public Object[][] dataProvider() throws IOException {

		DataFormatter formatter = new DataFormatter();
		FileInputStream fileLocation = new FileInputStream(
				System.getProperty("user.dir") + "\\ExcelTestdata\\DataProvider.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		System.out.println(rowCount);
		System.out.println(columnCount);

		Object[][] data = new Object[rowCount - 1][columnCount];
		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;
	}
}
