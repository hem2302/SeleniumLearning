package file.upload.download.learning;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadLearning {
	public static void main(String[] args) throws InterruptedException {
		
		String downloadPath = System.getProperty("user.dir") + "\\DownloadDirectory";
		ChromeOptions option = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", downloadPath);
		option.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("flower.jpeg")).click();
		Thread.sleep(5000);
		// one way to list all the files and find the downloaded file among them using
		// for loop
		/*
		 * File fileLocation = new File(downloadPath); File[] totalFiles =
		 * fileLocation.listFiles();
		 * 
		 * for (File f : totalFiles) {
		 * 
		 * if (f.getName().equals("flower.jpeg")) {
		 * System.out.println("File is successfully downloaded"); } }
		 */

		// Another way without using for loop
		File fileLocation1 = new File(downloadPath + "\\flower.jpeg");
		if (fileLocation1.exists()) {
			System.out.println("File is successfully downloaded and found");
		}

	}
}
