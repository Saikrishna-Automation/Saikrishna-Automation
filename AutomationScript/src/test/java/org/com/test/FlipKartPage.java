/**
 * 
 */
package org.com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Saikrishna
 *
 */
public class FlipKartPage {
	
	 WebDriver driver; 
	  
	    public FlipKartPage(WebDriver driver) { 
	        this.driver = driver; 
	     
	    } 
	    
	
	    @FindBy(how = How.CLASS_NAME, using =  
	            "LM6RPg") 
	    WebElement searchBox; 
	    
	    @FindBy(how = How.CLASS_NAME, using =  
	            "_6BWGkk") 
	    WebElement priceText; 
	    
	    @FindBy(how = How.XPATH, using =  
	            "//*[@class='_2AkmmA _29YdH8']") 
	    WebElement loginButton; 
	    
	 
	    public void setProduct(String productName) { 
	    	searchBox.sendKeys(productName); 
	        } 

}
