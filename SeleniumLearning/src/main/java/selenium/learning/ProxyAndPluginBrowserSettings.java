package selenium.learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProxyAndPluginBrowserSettings {
	public static void main(String[] args) {
		
		//ChromeOptions to set the plugins, proxy and path on Chrome Browser
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		//set proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		option.setCapability("proxy", proxy);
		
		// blocking pop-up window
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//set default download directory
		Map<String,Object> prefs = new HashMap<String,Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");
		
		//for more information check the site https://chromedriver.chromium.org/capabilities
	}
}
