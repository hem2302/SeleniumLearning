package calendar.learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//calendar
public class CalendarLearning1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();

		// method calling to click the calendar
		clickCalendar("31", "April", "2024", driver);

	}

	//Utilities to click the calendar
	public static void clickCalendar(String selectDay, String selectMonth, String selectYear, WebDriver driver) {

		if (Integer.parseInt(selectDay) > 31) {
			System.out.println("Invalid date provided");
		}
		if (Integer.parseInt(selectDay) > 28 && selectMonth.equals("February")) {
			System.out.println("Invalid date provided");
		}

		// explicit wait to wait until the calendar shown
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

		String monthAndYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		System.out.println(monthAndYear);

		String month = monthAndYear.split(" ")[0];
		String year = monthAndYear.split(" ")[1];

		while (!(month.equals(selectMonth) && year.equals(selectYear))) {
			driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			monthAndYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
			month = monthAndYear.split(" ")[0];
			year = monthAndYear.split(" ")[1];
		}

		String xpathText = "//td[@data-handler='selectDay']/a[text()=\'" + selectDay + "\']";

		try {
			
			driver.findElement(By.xpath(xpathText)).click();
		} catch (Exception e) {
			System.out.println("The entered data is not valid from try and catch");
		}

	}

}
