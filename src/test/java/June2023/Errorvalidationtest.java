package Junebatch2023;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Junebatch2023.AbstractComponents.CartPage;
import Junebatch2023.AbstractComponents.Loginpage;
import Junebatch2023.AbstractComponents.ProductCatalogue;
import testcomponents.startup;


public class Errorvalidationtest extends startup{

	//public static void main(String[] args) {

	@Test(groups = {"Error1"})
	public void Errorvalidation() throws IOException, InterruptedException
	{	
		Loginpage.loginApplication("shamjijinjala@gmail.com", "26342654323");
		String Loginerrormessage = driver.findElement(By.id("toast-container")).getText();
		System.out.println("This is the error message: " + Loginerrormessage);
		Thread.sleep(5000);
		Assert.assertTrue(Loginerrormessage.equalsIgnoreCase("Incorrect email or password."));
		Thread.sleep(5000);
							
	}
	
	@Test(groups = {"Error"})
	public void Verifyproduct() throws IOException, InterruptedException {
		String ProductName = "ZARA COAT 3";
		
		ProductCatalogue ProductCatalogue = Loginpage.loginApplication("shamjijinjala@gmail.com", "Showit@12");
		Thread.sleep(5000);
		
		  List<WebElement> Products = ProductCatalogue.getProductList();
		  ProductCatalogue.getProductByName(ProductName); Thread.sleep(5000);
		  ProductCatalogue.addProductToCart(ProductName);
		 
		CartPage CartPage = ProductCatalogue.gotocartpage();
		Boolean match = CartPage.VerifyProductDisplay(ProductName);
		System.out.println("This is the Group Helper validation");
		Assert.assertTrue(match);
		
	}

}
