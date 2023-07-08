package googleconsentformclick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserParallelTest {

	@Parameters("browser")
	@Test
	public void crossBrowserParallelTest(String browser) {
		WebDriver driver;

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get("https://google.com");
			WebElement consent = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
			consent.click();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get("www.google.com");
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get("www.google.com");
		}
	}
}
