package locators.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathLearning {
	public static void main(String[] args) {

		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().create();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("(//button[@id='visitUsTwo'])")).click();
		//driver.quit();
	}
}
