package file.upload.download.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadLearning {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		  driver.get("https://the-internet.herokuapp.com/upload");
		  driver.findElement(By.id("file-upload")).sendKeys("D:\\test.txt");
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("file-submit")));
		  driver.findElement(By.id("file-submit")).click();
		  
		  //To run any exe file in java use the below syntax incase of using the AutoIT to upload the file
		  //Runtime.getRunTime().exec(path of the exe file);
		 

	}
}
