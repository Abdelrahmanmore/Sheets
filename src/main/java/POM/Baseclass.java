
package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Baseclass {
	
	static WebDriver driver;
	
	@BeforeTest
	public static void setup()
	{
		driver= new ChromeDriver();
		driver.get("https://www.citypopulation.de/en/qatar/admin/");
	}
	
	public static WebDriver get_driver() {
		return driver;
	}

}
