package Junebatch2023MastercopywithBeforemethodannotation;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Junebatch2023.AbstractComponents.Loginpage;
import testcomponents.startup;


public class loginvalidation extends startup{

	//public static void main(String[] args) {

	@Test
	public void Errorvalidation() throws IOException
	{	
		
		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
		 * ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.manage().window().maximize(); driver.get("https://www.google.com/");
		 * driver.navigate().to("https://rahulshettyacademy.com/client/");
		 */
		
		Loginpage loginpage = openapplication();
		/*
		 * driver.findElement(By.id("userEmail")).sendKeys("shamjijinjala@gmail.com");
		 * driver.findElement(By.id("userPassword")).sendKeys("Showit@123");
		 * driver.findElement(By.id("login")).click();
		 */
		loginpage.loginApplication("shamjijinjala@gmail.com", "26342654323");

		String Loginerrormessage = driver.findElement(By.id("toast-container")).getText();
		System.out.println("This is the error message: " + Loginerrormessage);
		Assert.assertTrue(Loginerrormessage.equalsIgnoreCase("Incorrect email or password."));
		driver.close();
		
	}

}
