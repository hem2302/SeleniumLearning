package streams.learning;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableSortedOrNot {
	public static void main(String[] args) {
		// click on the column
		// Capture all the WebElements in to list
		// capture text of all the WebElements in to a new list
		// sort in the list of step 3 - sorted list
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();

		List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
		List<String> originalList = list.stream().map(s -> s.getText()).collect(Collectors.toList());
		//originalList.stream().forEach(s -> System.out.println(s));
		List<String> newList = originalList.stream().sorted().collect(Collectors.toList());
		//newList.stream().forEach(s -> System.out.println(s));
		Assert.assertTrue(originalList.equals(newList));
	}
}
