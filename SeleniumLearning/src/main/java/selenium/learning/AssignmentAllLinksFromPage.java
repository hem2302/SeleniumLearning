package selenium.learning;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentAllLinksFromPage {
	public static void main(String[] args) {

		// 1. Give me the count of all links of the page
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String parentWindow = driver.getWindowHandle();
		System.out.println("Count of the links on the site: " + driver.findElements(By.xpath("//a")).size());

		// 2. print all the links only from the footer with limiting the webdriver scope

		WebElement footerDriver = driver
				.findElement(By.cssSelector("div[class*= 'footer_top_agile_w3ls gffoot footer_style']"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// 3. Links count of the first column from the footer.
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table//tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		// 4. Click on each link in the column and check if the pages are opening.
		// 5. get the title of each child page and close the child window/tab one by
		// one.
		// 6. Click each link using the Keys method Control plus enter/click and
		// for-each loop for optimized code

		for (int i = 0; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
		int count = 0;
		Set<String> handle = driver.getWindowHandles();

		// USING ITERATOR
		System.out.println("*** Using Iterator***");
		Iterator<String> it = handle.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

		System.out.println("*** Using for each loop ***");
		for (String child : handle) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				count++;
				System.out.println("The child window title " + count + " is " + driver.getTitle());

				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println("The parent window title is: " + driver.getTitle());
		driver.quit();

	}

}
