package windowhandles.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesAssignment {
	public static void main(String[] args) {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		Set<String> handle = driver.getWindowHandles();

		for (String child : handle) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println("The child window text is: "
						+ driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
				driver.close();
			}

		}

		driver.switchTo().window(parentWindow);
		System.out.println("Returned to parent window "
				+ driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
		driver.navigate().back();

	}
}
