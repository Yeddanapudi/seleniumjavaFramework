package day1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;


public class NewTest {
WebDriver d; 
@Parameters("OpenBrowser")
	  @BeforeTest
	  public void openingBrowser(String OpenBrowser) {
		  switch(OpenBrowser.toUpperCase())
			{

			case "CHROME":
				WebDriverManager.chromedriver().setup();
				ChromeOptions opt=new ChromeOptions();
				 opt.addArguments("--remote-allow-origins=*");	  
				 d=new ChromeDriver(opt);
				 break;
			
			case "FIREFOX":
				d=new FirefoxDriver();
				break;

			case "IE":
				System.setProperty("webdriver.ie.driver","D://IEdriverServer.exe");
				  d=new InternetExplorerDriver();
			break;
			
			default: 
					System.out.println("invalid browser");
			}
			d.manage().window().maximize();
			  d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	@Parameters({"url","username","password"})
  @Test
  public void Navigate(String url,String username, String password) {
	  d.get(url);
	  d.findElement(By.name("username")).sendKeys(username);
	  d.findElement(By.name("password")).sendKeys(password);
	  d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	 
 
  
  
  }
 
  @AfterTest
  public void ClosingBrowser() {
 d.quit();
  }
  
}
