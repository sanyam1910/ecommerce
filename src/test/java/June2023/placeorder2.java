package Junebatch2023;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Junebatch2023.AbstractComponents.CartPage;
import Junebatch2023.AbstractComponents.Loginpage;
import Junebatch2023.AbstractComponents.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import testcomponents.startup;

public class placeorder2 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		String ProductName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Loginpage loginpage = new Loginpage(driver);
		loginpage.URL();
		ProductCatalogue ProductCatalogue = loginpage.loginApplication("shamjijinjala@gmail.com", "Showit@12");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> Products = ProductCatalogue.getProductList();
		ProductCatalogue.getProductByName(ProductName);
		ProductCatalogue.addProductToCart(ProductName);
		CartPage CartPage = ProductCatalogue.gotocartpage();
		Boolean match = CartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CartPage.checkout();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector(".tot alRow button")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector((".hero-primary"))).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
