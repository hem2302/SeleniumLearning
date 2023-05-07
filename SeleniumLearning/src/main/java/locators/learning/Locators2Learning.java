package locators.learning;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators2Learning {

	public static void main(String[] args) throws InterruptedException {

		// ***Code for launching chrome driver***
		// System.setProperty("webdriver.http.factory", "jdk-http-client");
		// WebDriverManager.chromedriver().setup();
		// ChromeDriver driver = new ChromeDriver();

		// *** code for launching firefox driver***
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\Selenium\\SeleniumLearning\\Drivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		// *** code for launching Edge driver***
		System.setProperty("webdriver.edge.driver", "D:\\Selenium\\SeleniumLearning\\Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		String name = "hemakumar";
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']//child::h2")).getText());
		// Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']//child::h2")).getText(),
		// "Hello " +name+",");
		System.out.println(driver.findElement(By.tagName("p")).getText());
		// Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are
		// successfully logged in.");
		driver.findElement(By.xpath("//button[contains(text(),'Log Out')]")).click();
		Thread.sleep(5000);
		driver.quit();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		// Please use temporary password 'rahulshettyacademy' to Login.
		String[] stringPasswordArray = passwordText.split("'");
		String actualPassword = stringPasswordArray[1].split("'")[0];
		return actualPassword;

	}

}
