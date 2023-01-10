package vidume.cities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects.ToStringHelper;

import POM.city;


public class Main {

	public static void main(String[] args) throws IOException {

		//List<Map<String,city>> cities = new ArrayList<Map<String,city>>();
		//cities = read_ecxel_sheet.get_sheet("C:\\Users\\Hossam\\Desktop\\list contries vidume app.xlsx");
		//ObjectMapper mapper = new ObjectMapper();
		//mapper.writeValue(new File("C:\\Users\\Hossam\\amira.json"), cities);
		String a = new String(
				"Umm Şalāl Alī".getBytes(Charset.forName("UTF-8")),
				 Charset.forName("Cp1252")
				);
				System.out.println(a);
				System.out.println(
				    new String(
				        a.getBytes(Charset.forName("Cp1252")), 
				        Charset.forName("UTF-8")
				    )
				);
	
				
				
	
	}
}
