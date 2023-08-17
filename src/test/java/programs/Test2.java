package programs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
	RemoteWebDriver driver;
@Test(priority=1)
public void method1() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("http://www.sentia.com");
	Thread.sleep(3000);
}
@Test(priority=2)
public void method2()
{
	String x=driver.getWindowHandle();
	System.out.println(x);
	driver.close();
}
}
