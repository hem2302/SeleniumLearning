package streams.learning;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomStream {
	public static void main(String[] args) {

		// Scan the name column with getText() - >Beans - > print price of the Beans

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> price = list.stream().filter(s -> s.getText().contains("Rice"))
				.map(s -> getItemPrice(s)).collect(Collectors.toList());
		price.stream().forEach(a -> System.out.println("Price of the rice Item is: " + a));
	}

	private static String getItemPrice(WebElement a) {
		// TODO Auto-generated method stub
		String priceItem = a.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceItem;
	}

}
