package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tesclass {

	@Test
	public void checkDatePickeer() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri Jul 26 2024']")).click();

	}
}