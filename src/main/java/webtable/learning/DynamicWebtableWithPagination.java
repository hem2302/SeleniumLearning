package webtable.learning;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicWebtableWithPagination {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		// option.setExperimentalOption("excludeSwitches",
		// Arrays.asList("disable-popup-blocking"));
		// option.addArguments("disable-popup-blocking");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		// Login page
		driver.findElement(By.name("username")).sendKeys("demo");
		driver.findElement(By.name("password")).sendKeys("demo");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();

		/*
		 * for(String child:handle) { if( !parentWindow.equalsIgnoreCase(child)) {
		 * driver.switchTo().window(child); driver.close(); } }
		 */

		// driver.switchTo().window(parentWindow);

		// Sales -- Orders
		if (driver.findElement(By.cssSelector("div[class=modal-content] [class=btn-close]")).isDisplayed()) {
			driver.findElement(By.cssSelector("div[class=modal-content] [class=btn-close]")).click();
		}

		driver.findElement(By.partialLinkText("Sales")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']//a[normalize-space()='Orders']")).click();

		// Table
		String text = driver.findElement(By.cssSelector(".col-sm-6.text-end")).getText();
		int totalPageNumber = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println(totalPageNumber);

		for (int p = 1; p <= totalPageNumber; p++) {
			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println(activePage.getText());
			activePage.click();

			Thread.sleep(3000);
			int rows = driver.findElements(By.xpath("//*[@class='table table-bordered table-hover']//tbody//tr"))
					.size();
			System.out.println(rows);
			String pageNumber = Integer.toString(p + 1);
			
			//move to next page and click it
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text() = '" + pageNumber + "']")).click();

		}
	}
}
