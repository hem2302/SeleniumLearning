package dropdown.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithLoop {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.className("paxinfo")).getText());
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.className("paxinfo")).getText());
		driver.quit();

	}
}
