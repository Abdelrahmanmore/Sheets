package vidume.cities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import POM.city;
import POM.cityname;

public class read_ecxel_sheet {
	public static List<Map<String, city>> get_sheet(String path) throws IOException {
		XSSFWorkbook mybook;
		String file_location = path;
		File newFile = new File(file_location);
		FileInputStream file = new FileInputStream(newFile);
		mybook = new XSSFWorkbook(file); // finds the
		XSSFSheet mySheet = mybook.getSheetAt(0);
		Iterator<Row> rowIterator = mySheet.iterator(); // create a cursor called iterator to all rows in sheet

		Row r;
		Cell c;
		List<List<String>> sheet = new ArrayList<List<String>>();

		while (rowIterator.hasNext()) {
			List<String> inner = new ArrayList<String>();
			r = rowIterator.next();
			// Cursor points to row
			Iterator<Cell> cell_Iterator = r.cellIterator();

			while (cell_Iterator.hasNext()) {

				c = cell_Iterator.next();
				// Cursor points to cell

				inner.add(c.getStringCellValue());

			}
			sheet.add(inner);

			// System.out.println(" ");// next to display in table format
		}

		mybook.close();
		file.close();

		// Map<String, List<String>> Msheet = new HashMap<String, List<String>>();
		// Map<String, List<Map<String, specialization>>> Msheet = new HashMap<String,
		// List<Map<String, specialization>>>();
		// List<Map<String, specialization>> temp = new ArrayList<Map<String,
		// specialization>>();
		// Map<String, specialization> innermap = new HashMap<String, specialization>();
		List<Map<String, city>> cities = new ArrayList<Map<String, city>>();
		Map<String, city> outermap = new HashMap<String, city>();
		Map<String, String> innermap = new HashMap<String, String>();

		for (int i = 0; i <30; i += 2) {
			// List<String> temp = new ArrayList<String>();
			// temp = new ArrayList<Map<String, specialization>>();
			outermap = new HashMap<String, city>(); 
			for (int j = 1; j < 28; j++) {
				innermap = new HashMap<String, String>();
				outermap =  new HashMap<String, city>();
				if (sheet.get(j).get(i).equals(""))
					break;
				// temp.add(sheet.get(j).get(i));
				String stemp = sheet.get(j).get(i);
				stemp = stemp.replaceAll("\\s", "");

				cityname name = new cityname();
				name.ar = sheet.get(j).get(i + 1);
				name.en = sheet.get(j).get(i);

				city cityobj = new city();
				cityobj.label = new HashMap<String, String>();
				cityobj.label.put("ar",name.ar);
				cityobj.label.put("en",name.en);;
				cityobj.country = sheet.get(0).get(i).toLowerCase().replaceAll("\\s", "");

				outermap.put(stemp, cityobj);

				cities.add(outermap);
			}
			// String stemp = sheet.get(0).get(i);
			// stemp = stemp.replaceAll("\\s", "");
			// Msheet.put(stemp, temp);
			// System.out.println(" ");

		}
		System.out.print(cities.size());
		return cities;
	}
}
