/**
 * 
 */
package org.com.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.com.test.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Saikrishna
 *
 */
public class ProductCompare {

	static WebDriver driver;
	
	 private static final Logger logger = LoggerFactory.getLogger(ProductCompare.class);

	

	@BeforeMethod
	public void setUp() throws Exception {
		 System.setProperty("webdriver.chrome.driver", 
			        System.getProperty("user.dir") +  
			            "\\src\\test\\java\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	

	}

	@Test
	public void verifyProductCostTest() throws InterruptedException, IOException {
		String product = "iPhone XR (64GB) - Yellow";
		
		
		driver.get("https://www.amazon.in/");
		AmazonPage amazonPage = PageFactory.initElements(driver, AmazonPage.class);
		amazonPage.setProduct(product);
		amazonPage.searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(.,'" + product + "')]")).click();
		String amazonAmount = amazonPage.priceText.getText();
		System.out.println("AmazonPrice" + amazonAmount);
		Double amazonPriceValue = getValueFromString(amazonAmount);
		
		
		
		
		driver.get("https://www.flipkart.com/");
		FlipKartPage flipKartPage = PageFactory.initElements(driver, FlipKartPage.class);
		if (flipKartPage.loginButton.isDisplayed()) {
			flipKartPage.loginButton.click();
		}
		flipKartPage.setProduct(product);
		flipKartPage.searchBox.sendKeys(Keys.ENTER);
		String flipKartamount = flipKartPage.priceText.getText();

		System.out.println("FlipKart Price" + flipKartamount);
		Double flipKartPriceValue = getValueFromString(flipKartamount);
		if (amazonPriceValue == flipKartPriceValue) {
			System.out.println("Both Prices are equal");
			Assert.assertEquals(amazonPriceValue, flipKartPriceValue);
			
		} else if (amazonPriceValue < flipKartPriceValue) {
			System.out.println("Flip kart Price is high");
			Assert.assertTrue(amazonPriceValue < flipKartPriceValue, "product Price is high in Flipkart");
		} else {
			System.out.println("Amazon Price is high");
			Assert.assertTrue(amazonPriceValue > flipKartPriceValue, "product Price is high in Amazon");
			
		}
		driver.close();
	}

	private Double getValueFromString(String amount) {
		String processedAmount = amount.replaceAll("[₹ ,]*", "");
		System.out.println("processedamount" + processedAmount);
		Double amountValue = Double.parseDouble(processedAmount);
		return amountValue;

	}

}
