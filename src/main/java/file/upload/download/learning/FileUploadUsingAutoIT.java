package file.upload.download.learning;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingAutoIT {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Steps to upload the file with AutoIT tool
		// First Build the script using SciTe script editor
		// Save the file and it will be saved as. AU3 file.
		// Then convet the .AU3 file to .EXE file
		// Then integrate the .exe file and run using java Runtime.getRuntime().exec(path of the created .EXE file)
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.pdffiller.com/");
		driver.findElement(By.xpath("//*[contains(@class,'_2V07sR _1pRmkk _2BrVpl _1ILhXq')]")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\fileupload.exe");

	}
}
