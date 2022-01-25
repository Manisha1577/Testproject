package SeleniumTesting.Sshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Title {
	WebDriver driver;
	@Test
	public void Title() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String Title = driver.getTitle();
		System.out.println("The Title of the page is:"+Title);
		

		
	}
	
}
