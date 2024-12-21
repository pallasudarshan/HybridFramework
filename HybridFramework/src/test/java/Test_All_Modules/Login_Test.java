package Test_All_Modules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.Dalvkot.Vims_GenericUtility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test {

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities caps = new DesiredCapabilities();

		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();
		contentSettings.put("notifications", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		caps.setCapability(ChromeOptions.CAPABILITY, options);

		options.addArguments("use-fake-device-for-media-stream");
		options.addArguments("use-fake-ui-for-media-stream");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		options.addArguments("--remote-allow-origins=*");

		options.addArguments("--headless");
		options.setHeadless(true);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://test.vykohms.com/vims-qa/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@placeholder='Email or Phone Number']"))
				.sendKeys("sudarshan1@dalvkot.com");

		driver.findElement(By.xpath("//button[text()='Next']")).click();

		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345");

		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn = null;
		try {
			loginAnywayBtn = driver.findElement(By.xpath("//button[text()='Login Anyway']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn != null) {
			loginAnywayBtn.click();
		}
	}
}