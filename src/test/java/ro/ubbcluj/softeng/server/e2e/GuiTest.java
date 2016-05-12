package ro.ubbcluj.softeng.server.e2e;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuiTest {

	public static final String BUTTON = "action_button";
	public static final String MSG_FIELD = "message_from_server";
	public static final String URL = "http://localhost:8080/TestApp/";
	public static final String DATA = "some data 1, some data 2, some data 3, some data 4,";
	//@Test
	public void testUserInterface() {
		// Optional, if not specified, WebDriver will search your path for
		// chromedriver.
		System.setProperty("webdriver.chrome.driver",
				"C:\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(URL);
		Assert.assertTrue(driver.findElements(By.id(BUTTON)).size() > 0);

		driver.findElement(By.id(BUTTON)).click();
		
		String s = driver.findElement(By.id(MSG_FIELD)).getText();
		
		Assert.assertEquals(DATA, s);
		
		driver.close();
	}
}
