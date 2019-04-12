package com.qa.GuruBank.ManagerModules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.GuruBank.Base.GuruBankBase;

public class CreateNewCusstomer extends GuruBankBase{
	
	@FindBy (name ="name")
	WebElement CstName;
	
	@FindBy (xpath="//input [contains(text(),'male')]")
	WebElement Role1;
	
	@FindBy (xpath="//input [@type='date']")
	WebElement BirthDate;
	@FindBy (xpath="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
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
	
	public CreateNewCusstomer() {
		PageFactory.initElements(driver, this);
	}
	
	

}
