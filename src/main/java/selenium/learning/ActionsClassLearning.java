package selenium.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassLearning {
	public static void main(String[] args) throws InterruptedException {

		// MouseMovement, Drag and Drop
		// Mouse Events
		/*
		 * clickAndHold; doubleClick(); contextClick(); dragAndDrop(); dragAndDropBy();
		 * moveToElement(); moveByOffset(); release();
		 */
		// Keyboard Events
		// keyDown
		// keyUp
		// sendKeys
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("test").build().perform();

		WebElement id = driver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(id).contextClick().build().perform();
		action.moveToElement(id).doubleClick().build().perform();
	}
}
