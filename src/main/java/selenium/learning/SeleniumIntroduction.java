package selenium.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumIntroduction {

	public static void main(String[] args) {

		/*
		 * WebDriver driver = new FirefoxDriver();
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Selenium\\SeleniumLearning\\Drivers\\geckodriver.exe");
		 * driver.get("https://rahulshettyacademy.com");
		 * System.out.println(driver.getCurrentUrl());
		 * System.out.println(driver.getTitle()); driver.close();
		 */
				
				/*
				 * ChromeOptions ops = new ChromeOptions();
				 * ops.addArguments("--remote-allow-origins=*");
				 */		
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumLearning\\Drivers\\chromedriver.exe");
		
		  System.setProperty("webdriver.http.factory", "jdk-http-client");
		  WebDriverManager.chromedriver().setup(); 
		  WebDriver driver = new ChromeDriver(); 
		  driver.get("https://www.youtube.com");
		  System.out.println(driver.getTitle()); 
		  driver.quit();
		 

	}
}
