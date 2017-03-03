package PageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ResultsPage{

	private static WebElement element = null;
	
	public WebElement searchMsgProductCount(WebDriver driver){
		element = driver.findElement(By.className("js-product-count"));
		return element;
	}
	
	public WebElement searchMsgArticleCount(WebDriver driver){
		element = driver.findElement(By.className("js-article-count"));
		return element;
	}
		
	public WebElement paginationText(WebDriver driver){
		element = driver.findElement(By.className("pages-qty"));
		return element;
	}
	
	public WebElement paginationLastPage(WebDriver driver){
		element = driver.findElement(By.className("last-page"));
		return element;
	}
	
	public WebElement paginationFirstPage(WebDriver driver){
		element = driver.findElement(By.className("first-page"));
		return element;
	}
	
	public WebElement paginationNextPage(WebDriver driver){
		element = driver.findElement(By.className("next-page"));
		return element;
	}
	
	public WebElement paginationPreviousPage(WebDriver driver){
		element = driver.findElement(By.className("previous-page"));
		return element;
	}
	
	public String getDefaultSettingResultsPerPage(WebDriver driver){
		element = driver.findElement(By.id("ui-results-qty"));
		return element.getText();
	}
	
	public String getDefaultSortBy(WebDriver driver){
		element = driver.findElement(By.id("ui-sort-by"));
		return element.getText();
	}
	
	public void paginationSelectResultsPerPage(WebDriver driver, String dropDownText){
		driver.findElement(By.id("ui-results-qty")).click();
		new Select(driver.findElement(By.id("ui-results-qty"))).selectByVisibleText(dropDownText);
	}

	public void paginationSelectSortBy(WebDriver driver, String dropDownText){
		driver.findElement(By.id("ui-sort-by")).click();
		new Select(driver.findElement(By.id("ui-sort-by"))).selectByVisibleText(dropDownText);
	}

	public List<WebElement> getProductFromList(WebDriver driver){
		return driver.findElements(By.className("product-price"));
	}
	
}
