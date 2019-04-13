package com.qa.GuruBank.ManagerModules;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.GuruBank.Base.GuruBankBase;
import com.qa.GuruBank.Utility.Utilit;


public class ManagerLogin extends GuruBankBase {
	public Alert aler ;
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
	@FindBy (xpath="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
	WebElement GreetingMessg;
	@FindBy(id="site-name")
	WebElement SiteName;
	
	
	public ManagerLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateLogin(String un ,String pass ) {
		UserID.sendKeys(un);
		Pass.sendKeys(pass);
		Loginbtn.click();
			
		}
	public void ValidatLoginWithUNandPass() {
		UserID.sendKeys(prop.getProperty("username"));
		Pass.sendKeys(prop.getProperty("password"));
		Loginbtn.click();
	}
	public void CopyAlertMessage() {
		aler=driver.switchTo().alert();
		String Alertmessage =aler.getText();
		System.out.println("error message " + Alertmessage);
	}
	
	public void ValidateHighLightElement() {
		
		Utilit.FlashElement(Loginbtn,driver);
		Utilit.refreshPage();
		
	}
	
	public void  ValidateBorderElement() {
		Utilit.DrawBorder(SiteName, driver);
	}

}
