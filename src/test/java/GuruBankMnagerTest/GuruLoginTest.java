package GuruBankMnagerTest;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.GuruBank.Base.GuruBankBase;
import com.qa.GuruBank.ManagerModules.ManagerLogin;
import com.qa.GuruBank.Utility.Utilit;

public class GuruLoginTest extends GuruBankBase{
	public ManagerLogin managlogin;
	
	public GuruLoginTest() {
		super();
	}
	
	@DataProvider 
	public Object[][] GetTestData(){
		Object data [][] =Utilit.GetTestData("GuruTestData");
		return data;
		
	}
	
	@BeforeMethod 
	public void setup () {
		
		initialize();
		managlogin=new ManagerLogin();
		
	}
	
	@Test (dataProvider ="GetTestData")
	public void LoginTest(String username ,String password) {
		managlogin.ValidateLogin(username, password);
	}
	
	/*@Test 
	public void HighLoghtLoginbtn () {
		managlogin.ValidateHighLightElement();
		
	}
	@Test 
	public void BorderTest() {
		managlogin.ValidateBorderElement();
	}*/
	@AfterMethod 
	public void teardown() {
		driver.quit();
	}

}
