/**
 * 
 */
package org.com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Saikrishna
 *
 */
public class TripAdvisorsiteReviewPage {
	
	
    @FindBy(how = How.XPATH, using =  
            "//*[@class='ui_icon search brand-global-nav-action-search-Search__icon--2DVjd']") 
    WebElement searchBox;
    
    
    @FindBy(how = How.XPATH, using =  
            "//*[@id='mainSearch']") 
    WebElement mainSearch; 
    
    
    
    @FindBy(how = How.XPATH, using =  
            "//*[@class='resultContainer local']/child::li[1]") 
    WebElement selectedResultUrl; 
    
    
    @FindBy(how = How.PARTIAL_LINK_TEXT, using =  
            "Write a review") 
    WebElement reviewLink; 
    
    @FindBy(how = How.ID, using =  
            "ReviewTitle") 
    WebElement reviewTitle; 
    
    @FindBy(how = How.ID, using =  
            "ReviewText") 
    WebElement reviewText; 
    
    @FindBy(how = How.XPATH, using =  
            "//*[@id='trip_type_table']/div[1]") 
    WebElement selectTripType; 
    
    @FindBy(how = How.ID, using =  
            "trip_date_month_year") 
    WebElement travelOptions; 
    
    @FindBy(how = How.ID, using =  
            "noFraud") 
    WebElement aggrementCheck; 
    
    @FindBy(how = How.XPATH, using =  
            "//*[@id='bubble_rating']") 
    WebElement overAllrating;
    
    @FindBy(how = How.XPATH, using =  
            "//*[@id='DQ_RATINGS']/div[1]") 
    WebElement hotelRatings;
    
    
    @FindBy(how = How.XPATH, using =  
            "//*[text()='Hotel Ratings']/following-sibling::div[1]/child::div[1]/child::div[2]/child::div/span") 
    WebElement serviceRating;
    
    @FindBy(how = How.XPATH, using =  
            "//*[text()='Hotel Ratings']/following-sibling::div[1]/child::div[2]/child::div[2]/child::div/span") 
    WebElement roomsRating;
    @FindBy(how = How.XPATH, using =  
            "//*[text()='Hotel Ratings']/following-sibling::div[1]/child::div[3]/child::div[2]/child::div/span") 
    WebElement sleepQualityRating;
    
    @FindBy(how = How.XPATH, using =  
            "//*[@id='BODY_BLOCK_JQUERY_REFLOW']") 
    WebElement body; 
    
  
    public void setName(String name) { 
    	mainSearch.sendKeys(name); 
        } 
  
    public void setReviewTitle(String name) { 
    	reviewTitle.sendKeys(name); 
        } 
    

    public void setReviewText(String name) { 
    	reviewText.sendKeys(name); 
        } 
}
