package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleGoogleCookiesConsentForm {
	public static void main(String[] args) {
		// System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		option.addArguments("--disable-notifications");
		option.addArguments("ignore-certificate-errors");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.google.com");
		if (driver.findElement(By.id("L2AGLb")).isDisplayed()) {
			driver.findElement(By.id("L2AGLb")).click();
		}
	}
}
