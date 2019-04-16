package com.qa.GuruBank.ManagerModules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.GuruBank.Base.GuruBankBase;
import com.qa.GuruBank.Utility.Utilit;


public class ManagerLogin extends GuruBankBase {
	@FindBy (name ="uid")
	WebElement UserID;
	@FindBy (name ="password")
	WebElement Pass;
	@FindBy (name="btnLogin")
	WebElement Loginbtn;
	@FindBy (name ="btnReset")
	WebElement Resetbtn;
	@FindBy (id ="message23")
	WebElement UNMessage;
	@FindBy (id="message18")
	WebElement PassMessage;
	@FindBy (xpath="//marquee[@class='heading3']")
	WebElement GreetingMessg;
	@FindBy(id="site-name")
	WebElement SiteName;
	
	
	public ManagerLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void  ValidateLogin(String un ,String pass ) {
		UserID.sendKeys(un);
		Pass.sendKeys(pass);
		Loginbtn.click();
		
		}
	public String  VerifyLoginPass() {
		return GreetingMessg.getText();
	}
	
	public void ValidatLoginWithUNandPass() {
		UserID.sendKeys(prop.getProperty("username"));
		Pass.sendKeys(prop.getProperty("password"));
		Loginbtn.click();
	}
	
	public void ValidateHighLightElement() {
		
		Utilit.FlashElement(Loginbtn,driver);
		Utilit.refreshPage();
		
	}
	
	public void  ValidateBorderElement() {
		Utilit.DrawBorder(SiteName, driver);
	}

}
