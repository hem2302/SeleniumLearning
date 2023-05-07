package selenium.learning;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaximizeWindowAndDeleteCookies {
	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		
		//Delete only the specific cookie with name
		driver.manage().deleteCookieNamed("hdhdhd");
		
		
		driver.get("https://expired.badssl.com/");
		
	}
}
