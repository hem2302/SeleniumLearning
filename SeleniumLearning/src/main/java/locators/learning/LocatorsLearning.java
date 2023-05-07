package locators.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsLearning {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Launch Website
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

		// Enter User name
		driver.findElement(By.id("inputUsername")).sendKeys("hemakumar.1986@gmail.com");

		// Enter passowrd
		driver.findElement(By.name("inputPassword")).sendKeys("abcd");

		// Click sign in button
		driver.findElement(By.className("signInBtn")).click();

		// Capture the incorrect username and password entry error message
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// Click forgot your password link
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();

		// Enter name on the forgot password page
		driver.findElement(By.xpath("//input[@placeholder='Name'][1]")).sendKeys("hemakumar");

		// Enter Email id on the forgot password page
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("hemakumar.1986@gmail.com");

		// Clear the entered email id on the email id field
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();

		// Enter email id again on the forgot password page
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("hemakumar.1986@gmail.com");

		// Enter phone number on the forgot password page
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("07861910146");

		// Click reset password button on the forgot password page
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// Capture the message with actual password which displayed on the forgot
		// password page
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		// Now click the go back to login page button on the forgot password page
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		Thread.sleep(1000);// Wait for 1 second to load the page.

		// Now Enter the username on the login page again
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("hemakumar");

		// Enter the captured password on the login page
		driver.findElement(By.cssSelector("input[type*='passw']")).sendKeys("rahulshettyacademy");

		// Click the checkbox accepting terms and conditions on the login page
		driver.findElement(By.cssSelector("#chkboxTwo")).click();

		// Now finally click the login button
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}
}
