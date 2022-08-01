package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.letskodeit.pageclasses.CategoryFilterPage;
import com.letskodeit.pageclasses.LoginPage;
import com.letskodeit.pageclasses.NavigationPage;
import com.letskodeit.pageclasses.ResultsPage;
import com.letskodeit.pageclasses.SearchBarPage;
import com.letskodeit.utilities.Constants;

public class BaseTest {
	public WebDriver driver;
	protected String baseURL;
	protected LoginPage login;
	protected NavigationPage nav;
	protected SearchBarPage search;
	protected ResultsPage result;
	protected CategoryFilterPage category;
	
	@BeforeClass
	@Parameters({"browser"})
	public void commonSetUp(String browser) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriverFactory.getInstance().getDriver(browser);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		baseURL = Constants.BASE_URL;
		driver.get(baseURL);
		nav = new NavigationPage(driver);
		login = nav.login();

	}
	@BeforeMethod
	public void methodSetup() {
		CheckPoint.clearHashMap();
	}
	
	@AfterClass
	public void commonTearDown() {
		//WebDriverFactory.getInstance().quitDriver();
	}
	
	
	
	
	
	
	
	
	
	
	
}
