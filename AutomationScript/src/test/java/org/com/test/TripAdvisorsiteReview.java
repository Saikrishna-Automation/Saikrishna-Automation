/**
 * 
 */
package org.com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.com.test.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Saikrishna
 *
 */
public class TripAdvisorsiteReview {

	static WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.tripadvisor.in/");

		// to maximize window

		driver.manage().window().maximize();

	}

	@Test
	public void verifyWebsiteReview() throws InterruptedException, IOException {
		driver.get("https://www.tripadvisor.in/");
		TripAdvisorsiteReviewPage reviewPage = PageFactory.initElements(driver, TripAdvisorsiteReviewPage.class);

		Thread.sleep(5000);
		reviewPage.searchBox.click();

		reviewPage.setName("Club Mahindra");
		Thread.sleep(2000);
		reviewPage.selectedResultUrl.click();
		Thread.sleep(5000);
		
				
		reviewPage.reviewLink.click();
		Set<String> noOfwindows = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(noOfwindows);
		driver.switchTo().window(windows.get(1));

		Thread.sleep(3000);
		reviewPage.overAllrating.click();
		Actions action = new Actions(driver);
		
		action.moveToElement(reviewPage.overAllrating).click(reviewPage.overAllrating).build().perform();
		action.moveByOffset(50, 0).click().build().perform();
		
		reviewPage.setReviewTitle("Recently visited this");
		reviewPage.setReviewText(
				"Beautiful place. Loved the location. Beach side, lovely breeze and hut kind sitting along side of the beach. It's just an Awesome place,Beautiful place. Loved the location. Beach side, lovely breeze and hut kind sitting along side of the beach. It's just an Awesome place");
		reviewPage.selectTripType.click();

		Select values = new Select(reviewPage.travelOptions);

		values.selectByIndex(1);
		if(reviewPage.hotelRatings.getText().equals("Hotel Ratings"))
		{
			Actions serviceRatingAction = new Actions(driver);
			
			serviceRatingAction.moveToElement(reviewPage.serviceRating).click(reviewPage.serviceRating).build().perform();
			serviceRatingAction.moveByOffset(50, 0).click().build().perform();
			
		Actions roomsRatingAction = new Actions(driver);
			
		roomsRatingAction.moveToElement(reviewPage.roomsRating).click(reviewPage.roomsRating).build().perform();
		roomsRatingAction.moveByOffset(50, 0).click().build().perform();
		
		Actions sleepQualityRatingAction = new Actions(driver);
		
		sleepQualityRatingAction.moveToElement(reviewPage.sleepQualityRating).click(reviewPage.sleepQualityRating).build().perform();
		sleepQualityRatingAction.moveByOffset(50, 0).click().build().perform();
		
		
		}
	
		// click on  check box

		reviewPage.aggrementCheck.click();
		

	}

}
