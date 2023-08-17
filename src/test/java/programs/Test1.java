package programs;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	 RemoteWebDriver driver;
		@Test(priority=1)
		public void method1() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//launch site
			driver.get("https://www.facebook.com");
			Thread.sleep(3000);
		}
		@Test(priority=2)
		public void method2() throws Exception
		{
			//collect logs
			Set<String> s=driver.manage().logs().getAvailableLogTypes();
			System.out.println(s);
			//get browser logs
			System.out.println("Browser logs:");
			LogEntries bl=driver.manage().logs().get("browser");
			for(LogEntry l:bl)
			{
				System.out.println(l.getMessage());
			}
			//get browser driver software logs
			System.out.println("Browser driver software logs:");
			LogEntries dl=driver.manage().logs().get("driver");
			for(LogEntry l:dl)
			{
				System.out.println(l.getMessage());
			}
			//get client logs(OS, N/W, Memory and other resources)
			System.out.println("client logs:");
			LogEntries cl=driver.manage().logs().get("client");
			for(LogEntry l:cl)
			{
				System.out.println(l.getMessage());
			}
		}
		@Test(priority=3)
		public void method3() throws Exception
		{
			driver.close();
		}

}
