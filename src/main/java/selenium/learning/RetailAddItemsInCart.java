package selenium.learning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetailAddItemsInCart {

	public static void main(String[] args) {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//implictlywait	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] itemsArray = { "Cucumber", "Beetroot", "Brocolli" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		RetailAddItemsInCart addItemsInCart = new RetailAddItemsInCart();
		addItemsInCart.addItem(driver, itemsArray);

		driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
		//Explicit wait
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Code applied ..!']")));
		System.out.println(driver.findElement(By.xpath("//span[text() = 'Code applied ..!']")).getText());
		driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();
	}

	public void addItem(WebDriver driver, String[] itemsArray) {

		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> name1 = Arrays.asList(itemsArray);
		int count = name1.size();
		int j = 0;
		for (int i = 0; i < items.size(); i++) {

			System.out.println(items.get(i).getText());

			String[] name = items.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// This if condition for array of items to be checked
			if (name1.contains(formattedName)) {
				driver.findElements(By.xpath("//button[text() = 'ADD TO CART']")).get(i).click();
				j++;
				if (j == count) {
					System.out.println("Break...");

					break;
				}
			}
		}

		// This if condition is for comparing single item
//		if (name.contains("Cucumber")) {
//			driver.findElements(By.xpath("//button[text() = 'ADD TO CART']")).get(i).click();
//		}

	}
}
