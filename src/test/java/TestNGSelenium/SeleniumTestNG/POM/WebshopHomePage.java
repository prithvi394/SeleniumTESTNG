package TestNGSelenium.SeleniumTestNG.POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class WebshopHomePage {
	
	@FindBy(how=How.LINK_TEXT,using="Log in")
	WebElement loginLink;
	
	@FindBy(how=How.LINK_TEXT,using="Register")
	WebElement registerlink;
	
	public void clickLoginLink(){
		loginLink.click();
	}
	
	public void clickRegisterlink(){
		registerlink.click();
	}
	
	
}
