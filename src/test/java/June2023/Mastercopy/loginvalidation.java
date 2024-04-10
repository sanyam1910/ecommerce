package Junebatch2023.Mastercopy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginvalidation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("shamjijinjala@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Showit@123");
		driver.findElement(By.id("login")).click();
		String Loginerrormessage = driver.findElement(By.id("toast-container")).getText();
		//String testerror1 = driver.findElement(By.xpath("(//div[@id='toast-container'])[1]")).getText();
		System.out.println("This is the error message " + Loginerrormessage);
		Assert.assertTrue(Loginerrormessage.equalsIgnoreCase("Incorrect email or password."));
	driver.close();

	}

}
