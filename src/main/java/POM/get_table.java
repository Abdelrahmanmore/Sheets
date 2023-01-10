package POM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.naming.LimitExceededException;

import org.apache.commons.io.IOExceptionList;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class get_table {

	public static void get(String path, String table_id) throws IOException {
		Baseclass.get_driver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement table = Baseclass.get_driver().findElement(By.id(table_id));
		List<WebElement> rows = new ArrayList<WebElement>();
		rows = table.findElements(By.tagName("tr"));
		List<List<String>> sheet = new ArrayList<List<String>>();

		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cells = new ArrayList<WebElement>();
			cells = rows.get(i).findElements(By.tagName("td"));
			List<String> row = new ArrayList<String>();
			for (int j = 0; j < cells.size(); j++) {
				row.add(cells.get(j).getText());
			}
			sheet.add(row);
		}

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("qatar areas");
		XSSFRow row;

		for (int i = 0; i < sheet.size(); i++) {
			row = spreadsheet.createRow(i);
			for (int j = 0; j < sheet.get(i).size(); j++) {
				row.createCell(j).setCellValue(sheet.get(i).get(j));
			}

		}
		FileOutputStream out = new FileOutputStream(new File(path));
		workbook.write(out);
	}
}
