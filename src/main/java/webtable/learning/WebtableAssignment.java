package webtable.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtableAssignment {
	public static void main(String[] args) {

		// 1. Find number of columns
		// 2. Find number of rows
		// 3. Print 3rd row

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		driver.findElement(By.xpath("//table[@id='product']"));
		System.out.println("The count of the columns: "
				+ driver.findElements(By.xpath("//table[@id='product'][@name='courses']//th")).size());
		System.out.println("The row count is: "
				+ driver.findElements(By.xpath("//table[@id='product'][@name='courses']//tr")).size());

		List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@id='product'][@name='courses']//tr[3]//td"));

		for (WebElement row : thirdRow) {
			String row1 = row.getText();
			System.out.println(row1);
		}
		driver.quit();
	}
}
