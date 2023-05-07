package dropdown.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticDropDown {
	public static void main(String[] args) {

		// ***Code for launching chrome driver*** //
		System.setProperty("webdriver.http.factory", "jdk-http-client"); //
		WebDriverManager.chromedriver().setup(); // ChromeDriver driver = new
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByIndex(1);
		System.out.println("Select by Index: "+dropDown.getFirstSelectedOption().getText());
		
		dropDown.selectByVisibleText("AED");
		System.out.println("Select by visible text: "+dropDown.getFirstSelectedOption().getText());

		dropDown.selectByValue("USD");
		System.out.println("Select by value: "+dropDown.getFirstSelectedOption().getText());

		//Get number of options from the dropdown
		
		List<WebElement> numberOfOptions= dropDown.getOptions();
		int size = numberOfOptions.size();
		
		//Select the Drop down option using sendkeys	
		
		staticDropdown.sendKeys("USD");
		
		
		
	}
}
