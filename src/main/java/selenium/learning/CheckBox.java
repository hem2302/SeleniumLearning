package selenium.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class CheckBox {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.http.factory","jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
				System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		//Get the count of all checkboxes avaiable on the page
		List<WebElement> checkBoxCount = driver.findElements(By.cssSelector("[type='checkbox']"));
		System.out.println(checkBoxCount.size());
	}
}
