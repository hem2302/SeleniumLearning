package windowauthentication.popuphandle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuthenticationPopupHandle {
	public static void main(String[] args) {
		// https://the-internet.herokuapp.com/basic_auth
		// syntax: https://username:password@url
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}
}

