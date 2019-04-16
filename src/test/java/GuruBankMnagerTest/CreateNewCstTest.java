package GuruBankMnagerTest;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.GuruBank.Base.GuruBankBase;
import com.qa.GuruBank.ManagerModules.CreateNewCusstomer;
import com.qa.GuruBank.ManagerModules.ManagerLogin;
import com.qa.GuruBank.Utility.Utilit;
import com.qa.Listner.ScreenShotListener;
@Listeners (ScreenShotListener.class)
public class CreateNewCstTest extends GuruBankBase {
	public ManagerLogin managlogin;
	public CreateNewCusstomer newcst ;
	public static String CreateNewCstDataPath ="C:\\Users\\ghadeermoh\\eclipse-workspace\\GuruBank\\src\\main\\java\\com\\qa\\TestData\\NewCstData.xlsx";                                        
	public static String ExpectedAlertmessage="customer created successfully";
	
	public CreateNewCstTest() {
		super();
	}
	@DataProvider 
	public Object[][] GetTestData() {
		Object data [][] =Utilit.GetTestData("CstData" ,CreateNewCstDataPath);
		return data;
	}
	@BeforeMethod 
	public void setup () {
		initialize();
		managlogin=new ManagerLogin();
		newcst =new CreateNewCusstomer();
		managlogin.ValidatLoginWithUNandPass();
		newcst.ValidatCstPage();	
	}
	
	
	@Test  (dataProvider="GetTestData")
	public void NewCstCreateTest(String cstname ,String birth ,String address ,String city ,String stat ,String pin ,String telephone ,String email) {
	
	newcst.ValidatCutomerCreation(cstname, birth, address, city, stat, pin, telephone, email);	
	try {
		String Alertmessage=Utilit.PopUpAlertMessage();
		Assert.assertEquals(Alertmessage ,ExpectedAlertmessage);
	}catch (NoAlertPresentException Ex) {	
		String PageText=driver.getTitle();
		System.out.println(PageText);
		Assert.assertEquals(PageText, "customer created successfully");
	};
	
	}
	
	@AfterMethod 
	public void teardown() {
		driver.quit();
	}

}
