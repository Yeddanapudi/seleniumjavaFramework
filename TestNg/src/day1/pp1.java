package day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class pp1 {
  WebDriver d;
@Parameters("openingBrowser")
  @BeforeTest
  public void initializeBrowser(String openingBrowser) {
	switch(openingBrowser)
	{

	case "chrome":
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		 opt.addArguments("--remote-allow-origins=*");	  
		 d=new ChromeDriver(opt);
		 break;
	
	case "firefox":
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
@Parameters("url")
@Test
  public void A(String url) {
	  d.get(url);
	  
  }
  @AfterTest
  public void Credentials()
  {
	  d.findElement(By.name("username")).sendKeys("Admin");
	  d.findElement(By.name("password")).sendKeys("admin123");
	  d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  
  }
}

