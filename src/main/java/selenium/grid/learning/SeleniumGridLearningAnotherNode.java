package selenium.grid.learning;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridLearningAnotherNode {

	@Test
	public void GridLearningFirefox() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		// caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		// caps.setPlatform(Platform.ANY);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.69:4444"), caps);
		driver.get("https://www.rahulshettyacademy.com/");
		//driver.findElement(By.name("q")).sendKeys("hemakumar");
		System.out.println(driver.getTitle()+": From firefox browser");
		driver.close();
	}
}
