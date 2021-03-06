package stepdefs;

import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePage;
import PageObjects.ResultsPage;

public class DomainClass {

	public static WebDriver driver = null;
	private ResultsPage results = new ResultsPage();
	private HomePage home = new HomePage();
	
	public DomainClass(){
		this.driver = driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sneddr02\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://dev07-storefront.aws.gha.kfplc.com/");
	}
	
	public void setup(String seachString){
		WebElement element = home.searchBoxText(driver);
		element.clear();
		element.sendKeys(seachString);
	}
	
	public boolean confirmThatTheResultsAreCorrect(){
		boolean confirmationStatus = false;
		home.searchButton(driver).click();
		if (home.searchMsg(driver).getText().contains("We found")){
			int paginationLastPageNumner = 0;
			if (results.paginationText(driver).isDisplayed()){
				paginationLastPageNumner = Integer.parseInt(getPageNumber("Last"));
				
			}
			confirmationStatus = paginationLastPageNumner > 1 ? true: false; 
		}
		return confirmationStatus;
	}

	public String getPageNumber(String position){
		String pageNumber = null;
		StringTokenizer tokString = new StringTokenizer(results.paginationText(driver).getText(), " ");
		int tokens = 0;
		while (tokString.hasMoreElements()){
			tokens++;
			String tokenChecker = tokString.nextElement().toString();
			if ((position.equals("current") || position.equals("first")) && (tokens == 2)){
				pageNumber = tokenChecker;
			} else {
				pageNumber = tokenChecker;
			}
		}
		return pageNumber;
	}

}
