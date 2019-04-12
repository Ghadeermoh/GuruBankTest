package GuruBankMnagerTest;

import org.testng.annotations.BeforeMethod;

import com.qa.GuruBank.Base.GuruBankBase;
import com.qa.GuruBank.ManagerModules.CreateNewCusstomer;
import com.qa.GuruBank.ManagerModules.ManagerLogin;

public class CreateNewCstTest extends GuruBankBase {
	public ManagerLogin managlogin;
	public CreateNewCusstomer newcst ;
	
	public CreateNewCstTest() {
		super();
	}
	
	@BeforeMethod 
	public void setup () {
		initialize();
		managlogin=new ManagerLogin();
		newcst =new CreateNewCusstomer();
		
	}

}
