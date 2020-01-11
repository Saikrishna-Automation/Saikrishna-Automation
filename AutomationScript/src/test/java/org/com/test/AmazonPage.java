package org.com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Saikrishna
 *
 */
public class AmazonPage {
	 WebDriver driver; 
	  
	    public AmazonPage(WebDriver driver) { 
	        this.driver = driver; 
	     
	    } 
	    
	
	    @FindBy(how = How.XPATH, using =  
	            "//*[@id=\"twotabsearchtextbox\"]") 
	    WebElement searchBox; 
	    
	    @FindBy(how = How.ID, using =  
	            "priceblock_ourprice") 
	    WebElement priceText; 
	    
	    
	    
	
	    public void setProduct(String productName) { 
	    	searchBox.sendKeys(productName); 
	        } 
	   
}
