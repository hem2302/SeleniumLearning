package dropdown.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveDropdownAssignment {
	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("india");
		System.out.println(driver.findElement(By.id("autocomplete")).getText());

		// get the entered text from the edit box using get attribute value since
		// gettext will not work
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		List<WebElement> suggestion = driver.findElements(By.xpath("//ul[contains(@id,'ui-id')]//li/div"));
		System.out.println(suggestion.size());
		for (int i = 0; i < suggestion.size(); i++) {
			System.out.println(suggestion.get(i).getText());
			if (suggestion.get(i).getText().equalsIgnoreCase("India")) {
				suggestion.get(i).click();
				break;
			}
		}
		// keys.DOWN will go down one by one and shift to the listed options/suggestions

		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// How to extract value from a field with Javascript Executor
		// String val = "return document.getElementById(\"hiddentext\").value;";
		// String text = (String)js.executeScript(val);
	}
}
