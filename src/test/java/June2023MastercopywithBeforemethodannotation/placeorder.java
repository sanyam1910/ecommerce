package Junebatch2023MastercopywithBeforemethodannotation;

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
import org.testng.annotations.Test;

import Junebatch2023.AbstractComponents.CartPage;
import Junebatch2023.AbstractComponents.CheckoutPage;
import Junebatch2023.AbstractComponents.Loginpage;
import Junebatch2023.AbstractComponents.ProductCatalogue;
import Junebatch2023.AbstractComponents.confirmationpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testcomponents.startup;

public class placeorder extends startup {

	public static WebDriver driver;
	@Test
	public void Submitorder() throws IOException, InterruptedException {
		String ProductName = "ZARA COAT 3";
		
		ProductCatalogue ProductCatalogue = Loginpage.loginApplication("shamjijinjala@gmail.com", "Showit@12");
		Thread.sleep(5000);
		List<WebElement> Products = ProductCatalogue.getProductList();
		ProductCatalogue.getProductByName(ProductName);
		Thread.sleep(5000);
		ProductCatalogue.addProductToCart(ProductName);
		CartPage CartPage = ProductCatalogue.gotocartpage();
		Boolean match = CartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		Thread.sleep(5000);
		CheckoutPage CheckoutPage = CartPage.checkout();
		System.out.println("This is the output on checkout method");
		CheckoutPage.selectCountry("india");
		System.out.println("Country is selected");
		confirmationpage confirmationpage = CheckoutPage.submitorder();
		String confirmMessage = confirmationpage.getconfirmationmessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
