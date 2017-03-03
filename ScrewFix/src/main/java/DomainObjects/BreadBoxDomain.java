package DomainObjects;

import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.FacetPage;
import PageObjects.HomePage;
import PageObjects.ResultsPage;
import stepdefs.DomainClass;

public class BreadBoxDomain extends DomainClass{

	private static WebDriver drive;
	private ResultsPage results = new ResultsPage();
	private HomePage home = new HomePage();
	private FacetPage facets = new FacetPage();
	private static String pageNumber = null;

	public BreadBoxDomain() {
		super();
	}

	public boolean confirmResultsPresent(){
		return results.searchMsgProductCount(drive).getText().isEmpty();
	}
	
	public boolean checkBreadBoxPresent(){
		WebElement facetBreadBox = null;
		facetBreadBox = facets.breadBoxPresent(super.driver);
		boolean present = facetBreadBox == null ? false : true;
		return present;
	}

	public void quitBrowser(){
		super.driver.quit();
	}
	
	public void closeBrowser(){
		super.driver.close();
	}

	public void singleFacetSelection() {
		// TODO Auto-generated method stub
		if (!checkBreadBoxPresent()){
			facets.addDifferentPrimaryFacet(super.driver);
		}
	}

	public boolean confirmBreadBoxListIsUpdated() {
		boolean actualFacetsSelected = facets.confirmListOfFacetSelected(super.driver, facets.getStoredFacetsList());
		
		return actualFacetsSelected;
	}

}
