package windowhandles.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowNavigation {
	public static void main(String[] args) {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();
		
	}
}
