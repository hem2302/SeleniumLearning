package selenium.learning;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {
	public static void main(String[] args) throws IOException, AWTException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://expired.badssl.com/");
		// Take Screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D://test.png"));
		
		// If alert comes first before the TakesScreenshot, It will not work. It will throw, unhandled alert exception.
		// Also TakesScreenshot cannot take full screenshot including the URL taskbar
		// etc.

		//Instead Robot class can be used to take the screenshot	
		
		//Using Robot to take screenshot
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage source = robot.createScreenCapture(rectangle); 
		File destinationFile = new File("D://robotscreenshot.png");
		ImageIO.write(source, "png", destinationFile);
	}
}
