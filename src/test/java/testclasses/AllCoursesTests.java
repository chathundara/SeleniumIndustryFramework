package testclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.letskodeit.pageclasses.NavigationPage;
import com.letskodeit.pageclasses.CategoryFilterPage;
import com.letskodeit.pageclasses.LoginPage;
import com.letskodeit.pageclasses.ResultsPage;
import com.letskodeit.pageclasses.SearchBarPage;
import com.letskodeit.utilities.Constants;
import com.letskodeit.utilities.ExcelUtility;

import base.BaseTest;
import junit.framework.Assert;

public class AllCoursesTests extends BaseTest {

//	WebDriver driver;
//	String baseURL;
//	LoginPage login;
//	NavigationPage nav;
//	SearchBarPage search;
//	ResultsPage result;
//	CategoryFilterPage category;

	@BeforeClass
	@Test
	public void setUp() {

		nav = login.signInWith(Constants.DEFAULT_LOGIN, Constants.DEFAULT_PASSWORD);
		ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTests");
	}

	@DataProvider(name = "verifySearchCourseData")
	public Object[][] getVerifySearchCourse() {
		Object[][] testData = ExcelUtility.getTestData("verify_search_course");
		return testData;
	}

	@Test(dataProvider="verifySearchCourseData")
	public void verifySearchCourse(String courseName) { // 2D Array has 1 column of data.. 
		nav.allCourses();
		// nav.myCourses();
		search = new SearchBarPage(driver);
		result = search.course(courseName);
		boolean searchResult = result.verifySearchResult();
		Assert.assertTrue(searchResult);
	}

	@Test
	public void filterByCategory() {
		nav.allCourses();
		category = new CategoryFilterPage(driver);
		result = category.select("Software IT");
		int count = category.findCoursesCount("Software IT");
		boolean filterresult = result.verifyFilterCourseCount(count);
		Assert.assertTrue(filterresult);
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
