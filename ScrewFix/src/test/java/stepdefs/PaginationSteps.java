package stepdefs;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import DomainObjects.PaginationDomain;
import PageObjects.ResultsPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class PaginationSteps implements En{

	String lastPageNumber = null;
	long numberOfProducts = 0;
	long pageDivisor = 0;
	String currentPageNumber = null;
	
	public PaginationSteps(){
		
		String basicSearchParam = "nails";

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sneddr02\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://dev07-storefront.aws.gha.kfplc.com/");
		PaginationDomain paginate = new PaginationDomain(driver);

		// the following 2 steps are related to the Background feature
		//   ----------------------------------
		Given("^the diy landing page is displayed$", () -> {
		    // Write code here that turns the phrase above into concrete actions
			paginate.setupSearchText(basicSearchParam);
		});

		Given("^there are several pages of search results displayed from a user search$", () -> {
		    // Write code here that turns the phrase above into concrete actions
			Assert.assertTrue(paginate.performSearchAndConfirmPaginatedPages());
		});
		//   ----------------------------------

		Given("^the last page button is enabled$", () -> {
		    // Write code here that turns the phrase above into concrete actions
		    Assert.assertTrue(paginate.isLastPageButtonEnabled());
		});

		When("^they click on the last page icon$", () -> {
		    // Write code here that turns the phrase above into concrete actions
			Assert.assertTrue(paginate.isLastPageButtonEnabled());
			paginate.navigateToPageInPagination("Last");
		});

		Then("^validate that the pagination text states that the user in on the last page$", () -> {
		    // Write code here that turns the phrase above into concrete actions
			paginate.waitFor(2000);
			String currentPage = paginate.getCurrentPage();
			String lastPage = paginate.getPageNumber("last");
			Assert.assertEquals(lastPage, currentPage);
			paginate.closeBrowser();
		});

		Given("^the first page button is enabled$", () -> {
		    // Write code here that turns the phrase above into concrete actions
		    if (!paginate.isFirstPageButtonEnabled()){
		    	paginate.navigateToPageInPagination("Last");
		    }
		});

		When("^they click on the first page icon$", () -> {
		    // Write code here that turns the phrase above into concrete actions
			paginate.navigateToPageInPagination("First");
		});

		Then("^validate that the pagination text states that the user in on the first page$", () -> {
		    // Write code here that turns the phrase above into concrete actions
			String firstPage = paginate.getCurrentPage();
			Assert.assertTrue("current page is not the first page ", (firstPage.equals("1")));
			paginate.closeBrowser();
		});

		Given("^the default results page is displayed$", () -> {
		    // Write code here that turns the phrase above into concrete actions
		    Assert.assertTrue(paginate.generateSearchResults());
		});

		When("^they click on the \"([^\"]*)\"$", (String Page) -> {
		    // Write code here that turns the phrase above into concrete actions
		    switch (Page){
		    case "Next":
		    	if (!paginate.isNextPageButtonEnabled()){
		    		paginate.navigateToPageInPagination("First");
		    		paginate.waitFor(1000);
					currentPageNumber = paginate.getCurrentPage();
		    		paginate.navigateToPageInPagination(Page);
		    	} else {
					currentPageNumber = paginate.getCurrentPage();
		    		paginate.navigateToPageInPagination(Page);
		    	}
		    	break;
		    case "Previous":
		    	if (paginate.isPreviousPageButtonEnabled()){
		    		paginate.navigateToPageInPagination("Last");
		    		paginate.waitFor(1000);
					currentPageNumber = paginate.getCurrentPage();
		    		paginate.navigateToPageInPagination(Page);
		    	} else {
					currentPageNumber = paginate.getCurrentPage();
		    		paginate.navigateToPageInPagination(Page);
		    	}
		    	break;
		    default :;
		    }
		    paginate.waitFor(2000);
		});

		Then("^validate that the pagination text states that the user in on the correct \"([^\"]*)\"$", (String Page) -> {
		    // Write code here that turns the phrase above into concrete actions
			String newPage = paginate.getCurrentPage();
		    switch (Page){
		    case "Next":
		    	Assert.assertTrue("this is not the next page ", newPage.equals(String.valueOf(Integer.parseInt(currentPageNumber)+1)));
		    	break;
		    case "Previous":
		    	Assert.assertTrue("this is not the previous page ", newPage.equals(String.valueOf(Integer.parseInt(currentPageNumber)-1)));	    	
		    	break;
		    default :;
		    }
		    paginate.closeBrowser();
		});

		Given("^the results are over several pages$", () -> {
		    // Write code here that turns the phrase above into concrete actions
			paginate.setupSearchText(basicSearchParam);
			Assert.assertTrue(paginate.generateSearchResults());
			Assert.assertTrue(paginate.checkThatSearchHasPagination());
		});

		When("^the user increases the items per page  (\\d+)$", (Long resultsOption) -> {
		    // Write code here that turns the phrase above into concrete actions
			pageDivisor = resultsOption;
			lastPageNumber = paginate.getPageNumber("Last");
			String itemCount = paginate.getNumberOfProducts();
			numberOfProducts = Long.valueOf(paginate.getNumberOfProducts());
			paginate.setResultsPerPageValue(String.valueOf(pageDivisor));
		});

		Then("^validate that the number of pagination pages are also reduced accordingly$", () -> {
		    // Write code here that turns the phrase above into concrete actions
		    paginate.waitFor(3000);
		    long expectedPageCount = (numberOfProducts + pageDivisor -1) / pageDivisor;
		    long actualtPageCount = Long.valueOf(paginate.getPageNumber("Last"));
		    Assert.assertTrue(expectedPageCount == actualtPageCount);
			paginate.closeBrowser();
		});

		When("^the user increases the items per page to (\\d+)$", (Long resultsOption) -> {
		    // Write code here that turns the phrase above into concrete actions
			pageDivisor = resultsOption;
			lastPageNumber = paginate.getPageNumber("Last");
			String itemCount = paginate.getNumberOfProducts();
			numberOfProducts = Long.valueOf(paginate.getNumberOfProducts());
			paginate.setResultsPerPageValue(String.valueOf(pageDivisor));
		});

		When("^the user changes the Sort By to \"([^\"]*)\"$", (String sortText) -> {
		    // Write code here that turns the phrase above into concrete actions
		    paginate.setSortByValue(sortText);
		});

		Then("^validate that the pagination hasn't changed but the results are \"([^\"]*)\"$", (String sortBySelection) -> {
		    // Write code here that turns the phrase above into concrete actions
		    paginate.waitFor(3000);
			Assert.assertTrue(paginate.checkSortBy(sortBySelection));
			paginate.closeBrowser();
		});

				
		When("^the user selects the Sort By for \"([^\"]*)\"$", (String resultsOrdering) -> {
		    // Write code here that turns the phrase above into concrete actions
			paginate.setSortByValue(resultsOrdering);
		});

		Then("^validate that results are correct for the order selected by \"([^\"]*)\"$", (String resultsOrdering) -> {
		    // Write code here that turns the phrase above into concrete actions
		    paginate.waitFor(2000);
		    Assert.assertTrue(paginate.checkSortBy(resultsOrdering));
		    paginate.closeBrowser();
		});

		//   ++++++++++++++++++++++++++++++++++
//		This commented out section handles data tables in the feature file both single column and multi column tables
//
		
//		When("^the user changes the Sort By for type according to order$", (DataTable sortByData) -> {
//		    // Write code here that turns the phrase above into concrete actions
//		    // For automatic transformation, change DataTable to one of
//		    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//		    // E,K,V must be a scalar (String, Integer, Date, enum etc)
//			String sortString = null;
//			List<List<String>> data = sortByData.raw();
//			Iterator<List<String>> itr = data.listIterator();
//			while(itr.hasNext()){
//				Iterator<String> itr2 = itr.next().iterator();
//				while(itr2.hasNext()){
//					sortString = itr2.next();
//					if (sortString.contains(" to ") ? true : false){
//						paginate.setSortByValue(sortString);
//						break;
//					}
//				}
//			}
//		});
//
//		Then("^validate that results are correct for the order selected$", (DataTable resultOrder) -> {
//		    // Write code here that turns the phrase above into concrete actions
//		    // For automatic transformation, change DataTable to one of
//		    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//		    // E,K,V must be a scalar (String, Integer, Date, enum etc)
//			List<String> data = resultOrder.topCells();
//			Iterator<String> itr = data.iterator();
//			while(itr.hasNext()){
//				Assert.assertTrue(paginate.checkSortBy(itr.next()));
//			}
//			paginate.closeBrowser();
//		});

	}


}
