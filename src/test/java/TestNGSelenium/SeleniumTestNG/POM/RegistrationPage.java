package TestNGSelenium.SeleniumTestNG.POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class RegistrationPage {
	
	@FindBy(how=How.ID, using="FirstName" )
	WebElement firstName;
	
	@FindBy(how=How.ID, using="LastName" )
	WebElement LastName;
	
	@FindBy(how=How.ID, using="Email" )
	WebElement email;
	
	@FindBy(how=How.ID, using="gender-male" )
	WebElement maleRadioButton;
	
	@FindBy(how=How.ID, using="gender-female" )
	WebElement femaleRadioButton;
	
	@FindBy(how=How.ID, using="Password" )
	WebElement password;
	
	@FindBy(how=How.ID, using="ConfirmPassword" )
	WebElement confirmPassword;
	
	@FindBy(how=How.ID, using="register-button" )
	WebElement registerButton;
	
	public void populateFields(){
		
		maleRadioButton.click();
		firstName.sendKeys("Prakash1");
		LastName.sendKeys("Raj1");
		email.sendKeys("prakash11.raj@gmail.com");
		password.sendKeys("passw0rd1");
		confirmPassword.sendKeys("passw0rd1");
		registerButton.click();
	}
	
	
	
	
	
}
