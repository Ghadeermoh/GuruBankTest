package com.qa.GuruBank.ManagerModules;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.GuruBank.Base.GuruBankBase;

public class CreateNewCusstomer extends GuruBankBase{
	
	@FindBy (name ="name")
	WebElement CstName;
	
	@FindBy (xpath="//input [@type='radio']")
	WebElement Role1;
	
	@FindBy (xpath="//input [@type='date']")
	WebElement BirthDate;
	@FindBy (name="addr")
	WebElement Address;
	
	@FindBy (name="city")
	WebElement City;
	
	@FindBy (name="state")
	WebElement State;
	
	@FindBy (name="pinno")
	WebElement PIN;
	
	@FindBy (name="telephoneno")
	WebElement Telephone;
	
	
	@FindBy (name="emailid")
	WebElement Email;
	
	@FindBy (xpath="//input[@type='submit']")
	WebElement Submit;
	@FindBy (linkText="New Customer")
	WebElement NewcstLink;
	
	public CreateNewCusstomer() {
		PageFactory.initElements(driver, this);
	}
	public void ValidatCstPage() {
		NewcstLink.click();
	}
	public void ValidatCutomerCreation(String CustName ,String Birthdate ,String Addr ,String Cit ,String Sta, String Pin ,String Tele ,String Ema ) {
	
		CstName.sendKeys(CustName);
		BirthDate.sendKeys(Birthdate);
		Address.sendKeys(Addr);
		City.sendKeys(Cit);
		State.sendKeys(Sta);
		PIN.sendKeys(Pin);
		Telephone.sendKeys(Tele);
		Email.sendKeys(Ema);
		Role1.click();
		Submit.click();
		
	}

}
