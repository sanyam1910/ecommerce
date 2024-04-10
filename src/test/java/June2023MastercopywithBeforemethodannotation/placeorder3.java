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

public class placeorder3 extends startup{

	public static WebDriver driver;

	//public static void main(String[] args) throws InterruptedException, IOException {
@Test
public void Submitorder() throws IOException, InterruptedException
{
		String ProductName = "ZARA COAT 3";
		
		
		 // Added in Base Test 
			/*
			 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
			 * ChromeDriver();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 * driver.manage().window().maximize();
			 */
		//initializedriver();
		 
		Loginpage loginpage =openapplication();
		 
		/*
		 * startup startup = new startup(); startup.initializedriver();
		 * startup.navigatetoURL();
		 */
		
		//initializedriver();
		
		// driver.get("https://rahulshettyacademy.com/client/");

		/*
		 * System.setProperty("webdriver.chrome.drive",
		 * "G:\\Software Testing\\Programing\\June2023Batch\\Driver\\chromedriver.exe");
		 */
		/*
		 * WebDriver driver = new ChromeDriver();
		 * driver.get("https://rahulshettyacademy.com/client/");
		 */

		/*
		 * System.setProperty("webdriver.edge.driver",
		 * "G:\\Software Testing\\Programing\\June2023Batch\\Driver\\msedgedriver.exe");
		 * 
		 * WebDriver driver = new EdgeDriver(); driver.manage().window().maximize();
		 * 
		 * driver.get("https://www.google.com/");
		 * driver.navigate().to("https://rahulshettyacademy.com/client/");
		 */
		// System.out.println(driver.getTitle());

		/*
		 * driver.findElement(By.id("userEmail")).sendKeys("shamjijinjala@gmail.com");
		 * driver.findElement(By.id("userPassword")).sendKeys("Showit@12");
		 * driver.findElement(By.id("login")).click();
		 */

	//	Loginpage loginpage = new Loginpage(driver); //Added in BAse Test
	//	loginpage.URL(); //Added in Base Test
		ProductCatalogue ProductCatalogue = loginpage.loginApplication("shamjijinjala@gmail.com", "Showit@12");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		//ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		List<WebElement> Products = ProductCatalogue.getProductList();

		// List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));

		/*
		 * WebElement prod = Products.stream() .filter(product ->
		 * product.findElement(By.cssSelector("b")).getText().equals(ProductName)).
		 * findFirst() .orElse(null);
		 */
		ProductCatalogue.getProductByName(ProductName);

		// System.out.println("This is the value of the Prod variable" +
		// prod.getText());

		Thread.sleep(5000);
		// prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		// prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-star-inserted")));
		ProductCatalogue.addProductToCart(ProductName);
		// driver.findElement(By.cssSelector(("button[routerlink='/dashboard/cart']"))).click();
		CartPage CartPage =ProductCatalogue.gotocartpage();
		/*
		 * List<WebElement> cartProducts =
		 * driver.findElements(By.cssSelector(".cartSection h3")); 
		 * Boolean match = cartProducts.stream() .anyMatch(cartProduct ->
		 * cartProduct.getText().equalsIgnoreCase(ProductName));
		 */
		//CartPage CartPage = new CartPage(driver);
		Boolean match = CartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		//checkout
		
		CheckoutPage CheckoutPage = CartPage.checkout();
		CheckoutPage.selectCountry("india");
		confirmationpage confirmationpage = CheckoutPage.submitorder();
		
		String confirmMessage = confirmationpage.getconfirmationmessage();

		
		
		/*
		 * Thread.sleep(10000);
		 * driver.findElement(By.cssSelector(".totalRow button")).click();
		 * 
		 * Actions a = new Actions(driver);
		 * a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']"
		 * )), "india").build().perform();
		 * 
		 * Thread.sleep(5000); //
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
		 * ".ta-result")));
		 * driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).
		 * click(); driver.findElement(By.cssSelector(".action__submit")).click();
		 * String confirmMessage =
		 * driver.findElement(By.cssSelector((".hero-primary"))).getText();
		 */
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

	}

}

