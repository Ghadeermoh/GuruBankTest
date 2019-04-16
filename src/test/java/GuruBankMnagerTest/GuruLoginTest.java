package GuruBankMnagerTest;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.GuruBank.Base.GuruBankBase;
import com.qa.GuruBank.ManagerModules.ManagerLogin;
import com.qa.GuruBank.Utility.Utilit;
import com.qa.Listner.ScreenShotListener;
@Listeners (ScreenShotListener.class)
public class GuruLoginTest extends GuruBankBase{
	public ManagerLogin managlogin;
	public static String LoginDataPath ="C:\\Users\\ghadeermoh\\eclipse-workspace\\GuruBank\\src\\main\\java\\com\\qa\\TestData\\GuruTestData.xlsx";
	public static String ExpectedTitle="Welcome To Manager's Page of GTPL Bank";
	
	public GuruLoginTest() {
		super();
	}
	
	@DataProvider 
	public Object[][] GetTestData(){
		Object data [][] =Utilit.GetTestData("GuruTestData" ,LoginDataPath);
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
		try {
			String Alertmessage=Utilit.PopUpAlertMessage();
			Assert.assertEquals(Alertmessage, "User is not valid");
			}catch (NoAlertPresentException Ex) {	
				String bo =managlogin.VerifyLoginPass();
				System.out.println(bo);
			   Assert.assertEquals(bo,ExpectedTitle);
			};
	}
	
	/*@Test 
	public void LoginPassTest() {
		managlogin.ValidatLoginWithUNandPass();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		managlogin.ValidatLoginWithUNandPass();
	}
	
	@Test 
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
