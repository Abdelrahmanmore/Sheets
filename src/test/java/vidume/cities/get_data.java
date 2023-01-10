package vidume.cities;

import java.io.IOException;

import org.testng.annotations.Test;

import POM.Baseclass;
import POM.get_table;

public class get_data extends Baseclass {

	@Test
	public void start() throws IOException  
	{
		get_table.get("C:\\Users\\Hossam\\GFGsheet.xlsx","tl");
	}
}
