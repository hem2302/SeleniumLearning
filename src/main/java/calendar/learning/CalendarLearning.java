package calendar.learning;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class CalendarLearning {
	public static void main(String[] args) throws InterruptedException {
		// Select the date with JavascriptExecutor.....

		System.out.println("*** SELECT THE DATE WITH JavascriptExecutor ***");

		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		//WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// option.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		//WebDriver driver = new ChromeDriver(option);
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		// String date = "03 Apr 2023";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('datepicker').value='03/13/2026'");
		
		//js.executeScript("arguments[0].setAttribute('value','20/03/2023')", element);

	}
}
