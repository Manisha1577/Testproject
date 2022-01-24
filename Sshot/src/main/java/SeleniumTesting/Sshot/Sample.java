package SeleniumTesting.Sshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
	
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchbrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			}
		}
	@AfterTest
	public void closebrowser() {
		driver.close();
		}
	public void navigatetourl(String Url) {
		driver.navigate().to(Url);
		}
	public String Title() {
		return driver.getTitle();
		}
	
	@Test
	public void method1() {
		driver.navigate().to("http://www.youtube.com");
		String Source=driver.getPageSource();
		String Title = driver.getTitle();
		String Url = driver.getCurrentUrl();
		Reporter.log(Title, true);
		Reporter.log(Url, true);
		Reporter.log(Source,true);
		}
	
		@Test
		public void scrollingmethod2 () throws InterruptedException {
			driver.navigate().to("https://www.facebook.com");
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
			Actions actions1 = new Actions(driver);
			actions1.sendKeys(Keys.PAGE_UP).build().perform();
			String Title = driver.getTitle();
			Reporter.log(Title, true);
			String Url = driver.getCurrentUrl();
			Reporter.log(Url, true);
			
			
		}
		@Test
		public void linksmethod3() {
			driver.navigate().to("https://www.google.com");
			List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println(links.size());
			for(int i=0;i<links.size();i++) {
				System.out.println(links.get(i).getText());
				String Title = driver.getTitle();
				Reporter.log(Title, true);
				String Url = driver.getCurrentUrl();
				Reporter.log(Url, true);
				
				
			}
		}
		
		
		public String ReadData(String Key) throws IOException {
			Properties properties = new Properties();
			FileInputStream fileinputstream = new FileInputStream("C:\\eclipse\\Sshot\\src\\main\\java\\SeleniumTesting\\Sshot\\config.properties");
			properties.load(fileinputstream);
			String value = properties.getProperty(Key);
			return value;
		}
		
		public void Screenshot(WebDriver driver,String name) throws IOException {
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("C:\\eclipse\\Sshot\\Screenshots\\"+name+".png");
			FileUtils.copyFile(SrcFile, DestFile);
		}
		
		@Test
		public void windowmethod4() throws IOException, InterruptedException {
			driver.get(ReadData("url"));
			driver.findElement(By.xpath("//a[text()=' Click this link to start new Tab '][2]")).click();
			String Parentwindow = driver.getWindowHandle();
			System.out.println(Parentwindow);
			ArrayList<String> allwindows = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(allwindows.get(1));
			driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(ReadData("firstname"));
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(ReadData("lastname"));
			Screenshot(driver,"facebook");
			
			String Title = driver.getTitle();
			Reporter.log(Title, true);
			
			String Url = driver.getCurrentUrl();
		    Reporter.log(Url, true);
			driver.switchTo().window(allwindows.get(0));
			String Title1 = driver.getTitle();
			Reporter.log(Title1, true);
			String Url1 = driver.getCurrentUrl();
			Reporter.log(Url1, true);
		}
		
		
		@Test
		public void dropdownmethod5() throws InterruptedException, IOException {
			driver.navigate().to("http://www.facebook.com");
			driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
			Thread.sleep(2000);
	        WebElement  daydropdown = driver.findElement(By.id("day"));
			Select obj = new Select(daydropdown);
			obj.selectByVisibleText("15");
			Screenshot(driver,"dropdown");
			
			
			WebElement  monthdropdown = driver.findElement(By.id("month"));
			Select obj1 = new Select(monthdropdown);
			obj1.selectByVisibleText("Mar");
			Screenshot(driver,"dropdown1");
			
			
			WebElement  yeardropdown = driver.findElement(By.id("year"));
			Select obj2 = new Select(yeardropdown);
			obj2.selectByVisibleText("2000");
			Screenshot(driver,"dropdown2");
			
			String Title = driver.getTitle();
			Reporter.log(Title, true);
			
			String Url = driver.getCurrentUrl();
			Reporter.log(Url, true);
			
			
		}
		
		
		@Test
		public void Actionclassmethod6() throws InterruptedException {
			driver.navigate().to("https://www.javatpoint.com/");
			//perform right click operation
			WebElement text = driver.findElement(By.xpath("//a[text()=' SQL']"));
			WebElement text1 = driver.findElement(By.xpath("//a[text()=' Java']"));
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			actions.contextClick(text).build().perform();
			actions.moveToElement(text1);
		}
		public void Draganddrop() {
			driver.navigate().to("https://demoqa.com/droppable");
			WebElement Source = driver.findElement(By.id(null)));
			WebElement Destination= driver.findElement(By.xpath("//a[text()=' Java']"));
			
			
		}
	
		
		
	
			
			
			
			
			
			
			
			
		}
			
			

		
			
			
			
			
			
		
			
			
			
			
			
		
			 
			

				
			
		
		


