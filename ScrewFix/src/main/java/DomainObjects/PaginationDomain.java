package DomainObjects;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePage;
import PageObjects.ResultsPage;
import javafx.scene.control.Pagination;

public class PaginationDomain {
	
	private static WebDriver drive;
	private ResultsPage results = new ResultsPage();
	private HomePage home = new HomePage();
	private static String pageNumber = null;
	public static String currentPageNumber = null;
	
	public PaginationDomain(WebDriver drive){
		this.drive = drive;
	}
	
	public void setupSearchText(String searchText){
		WebElement element = home.searchBoxText(drive);
		element.clear();
		element.sendKeys(searchText);
	}
	
	public boolean generateSearchResults(){
		boolean resultsGenerated;
		home.searchButton(drive).click();
		String resultsMessage = home.searchMsg(drive).getText();
		resultsGenerated = resultsMessage.contains("We found") ? true : false;
		return resultsGenerated;
	}
	
	public boolean checkThatSearchHasPagination(){
		boolean confirmation = false;
		confirmation = (results.paginationText(drive).getText().isEmpty() && checkMoreThanOnePage(results.paginationText(drive).getText())) ? false : true;
		return confirmation;
	}
	
	public boolean performSearchAndConfirmPaginatedPages(){
		
		boolean confirmation = false;
		home.searchButton(drive).click();
		String resultsMessage = home.searchMsg(drive).getText();
		if (resultsMessage.contains("We found")){
			confirmation = (results.paginationText(drive).getText().isEmpty() && checkMoreThanOnePage(results.paginationText(drive).getText())) ? false : true;
		}
		return confirmation;
	}
	
	public boolean isLastPageButtonEnabled(){
		return results.paginationLastPage(drive).isEnabled();
	}

	public boolean isFirstPageButtonEnabled(){
		return results.paginationFirstPage(drive).isEnabled();
	}

	public boolean isNextPageButtonEnabled(){
		return results.paginationNextPage(drive).isEnabled();
	}

	public boolean isPreviousPageButtonEnabled(){
		return results.paginationPreviousPage(drive).isEnabled();
	}

	public void navigateToPageInPagination(String direction){
		switch (direction)
		{
		case "First":
			if (results.paginationFirstPage(drive).isEnabled()){
				results.paginationFirstPage(drive).click();
			}
			break;
		case "Last":
			if (results.paginationLastPage(drive).isEnabled()){
				results.paginationLastPage(drive).click();
			}
			break;
		case "Next":
			if (results.paginationNextPage(drive).isEnabled()){
				results.paginationNextPage(drive).click();
			}
			break;
		case "Previous":
			if (results.paginationPreviousPage(drive).isEnabled()){
				results.paginationPreviousPage(drive).click();
			}
			break;
		default:;
		}
		try{
			Thread.sleep(2000);
		} catch (Exception e){}
	}
	
	public String getCurrentPage(){
		StringTokenizer tokString = new StringTokenizer(results.paginationText(drive).getText(), " ");
		String currentPage = null;
		int tokens = 0;
		while (tokString.hasMoreElements()){
			currentPage = tokString.nextElement().toString();
			tokens++;
			if (tokens == 2){
				break;
			}
		}
		return currentPage;
	}
	
	public boolean confirmCorrectPageIsDisplayed(String page){
		return false;
	}
	
	private boolean checkMoreThanOnePage(String text) {
	    int pageLimit = text.lastIndexOf("of ");
	    String str1 = text.substring(pageLimit+3, text.length());
	    int currentLimit = Integer.valueOf(str1);
		return currentLimit > 1 ? true : false;
	}
	
	public String getPageNumber(String position){
		StringTokenizer tokString = new StringTokenizer(results.paginationText(drive).getText(), " ");
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
	
	public boolean checkSortBy(String optionSelected){
		Iterator<WebElement> itr = results.getProductFromList(drive).iterator();
		double previousValue = Double.parseDouble(itr.next().getText().substring(1));
		double currentValue = 0;
		boolean selectedSort = true;
		
		while (itr.hasNext()){
			currentValue = Double.parseDouble(itr.next().getText().substring(1));
			switch (optionSelected){
			case "LowToHigh":
				selectedSort = previousValue <= currentValue ? true : false;
				break;
			case "HighToLow":
				selectedSort = previousValue >= currentValue ? true : false;
				break;
			default:;
			}
			if (!selectedSort) break;
			previousValue = currentValue;
		}
		return selectedSort;
	}
	
	public String getCurrentResultsPerPageSetting(){
		return results.getDefaultSettingResultsPerPage(drive);
	}
	
	public String getCurrentSortBySetting(){
		return results.getDefaultSortBy(drive);
	}
	
	public void setResultsPerPageValue(String dropDownSelection){
		results.paginationSelectResultsPerPage(drive, dropDownSelection);
	}
	
	public void setSortByValue(String dropDownSelection){
		results.paginationSelectSortBy(drive, dropDownSelection);
	}
	
	public String getNumberOfProducts(){
		return results.searchMsgProductCount(drive).getText();
	}
	
	public String getNumberOfArticles(){
		return results.searchMsgArticleCount(drive).getText();
	}
	
	public void closeBrowser(){
		drive.quit();
	}

	public void waitFor(int sleepTime) {
		try{
			Thread.sleep(sleepTime);
		} catch (Exception e) {}
	}

}
