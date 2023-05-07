package streams.learning;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationUsingStream {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// pull all the elements of the webtable first column
		List<String> price;
		do {
			List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
			 price = list.stream().filter(s -> s.getText().toLowerCase().contains("beans"))
					.map(s -> getPriceItem(s)).collect(Collectors.toList());
			price.forEach(s -> System.out.println("The price of the item beans is: "+s));
			
			//System.out.println("size = "+price.size());
			
			//pagination
			if(price.size()<1) {
				
				List<WebElement> list1 = driver.findElements(By.xpath("//tr//td[1]"));
				driver.findElement(By.cssSelector("a[aria-label*='Next']")).click();
				Thread.sleep(3000);
			}
		}while(price.size()<1);
		
	}

	private static String getPriceItem(WebElement s) {
		// TODO Auto-generated method stub
		String priceItem = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceItem;
	}
}
