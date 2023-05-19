package selenium.learning;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// driver.get("https://www.siteguru.co/free-seo-tools/broken-links");
		// driver.get("https://fatjoe.com/niche-edits/");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Broken URL
		// Step 1 - Is to get all urls tied up to the links using selenium
		// Java methods will call URL's and gets you the status code
		// If the status code is >400 then that url is not working - The link tied to
		// the link is broken.

		List<WebElement> list = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		System.out.println(list.size());

		SoftAssert a = new SoftAssert();
		for (int i = 0; i < list.size(); i++) {

			String url = list.get(i).getAttribute("href");
			//System.out.println(url);
		//	try {
				URL link = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) link.openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();

				int responseCode = conn.getResponseCode();
				System.out.println(responseCode);
				a.assertTrue(responseCode<400, "The given URL: " + list.get(i).getText() + " is a broken with code " + responseCode);
				
				/*
				 * if (responseCode > 400) { System.out.println("The given URL: " +
				 * list.get(i).getText() + " is a broken with code" + responseCode);
				 * a.assertTrue(false); }
				 */
				/*
				 * } catch (MalformedURLException e) { e.printStackTrace(); } catch
				 * (ClassCastException e) { e.printStackTrace(); } catch (IOException e) {
				 * e.printStackTrace(); }
				 */
		}
		a.assertAll();

	}
}
