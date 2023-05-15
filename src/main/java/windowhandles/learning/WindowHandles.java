package windowhandles.learning;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/");
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("a[class='optanon-allow-all accept-cookies-button']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1323,8338)");
		Thread.sleep(4000);
		//driver.findElement(By.cssSelector("img[alt='facebook logo']")).click();
		driver.findElement(By.cssSelector("img[alt='linkedin logo']")).click();
		driver.findElement(By.cssSelector("img[alt='youtube logo']")).click();

		Set<String> handle = driver.getWindowHandles();

		int count = handle.size();
		System.out.println("Total window count is: " + count);
		
		for(String child:handle) {
			if(!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			System.out.println(driver.getCurrentUrl()+ " "+ driver.getTitle());
			driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
		String[] test = driver.getTitle().split(" | ");
		
		
		for(int i=0;i<test.length;i++) {
			System.out.println(test[i]);
			
		}
		System.out.println(driver.getTitle());
		
		
	

	}
}
