package selenium.learning;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingHTTPSCertification {
	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		
		//FirefoxOptions
		//FirefoxOptions option = new FirefoxOptions();
		
		//EdgeOptions
		//EdgeOptions option = new EdgeOptions();
		
		//SafariOptions
		//SafariOptions opton = new SafariOptions();
		
		
		//ChromeOptions
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}
}
