package selenium.learning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentPracticePage {
	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();

		// Get the option2 text using relative xpath
		String option = driver
				.findElement(By.xpath("//div[@class='right-align']//fieldset//label[normalize-space()='Option2']"))
				.getText();
		System.out.println(driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());

		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		// Select dropDownOptions = new Select(dropDown);

		// selcting the option2 on the dropdown using sendkeys
		dropDown.sendKeys(option);

		// Enter the option2 on the name text box
		driver.findElement(By.id("name")).sendKeys(option);

		// Select the alert button
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();

		// get the option text from the displayed text on the alert using split method
		String alertTextOptionPrint = alertText.split(" ")[1];
		String splitAgain = alertTextOptionPrint.split(",")[0];
		// print the split text - option2
		System.out.println("The extracted name from the alert is: " + splitAgain);
		driver.quit();
	}
}
