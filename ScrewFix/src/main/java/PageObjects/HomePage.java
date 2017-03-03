package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static WebElement element = null;
		
	public WebElement searchBoxText(WebDriver driver){
		element = driver.findElement(By.id("search"));
		return element;
	}
	
	public WebElement searchButton(WebDriver driver){
		element = driver.findElement(By.id("search-button"));
		return element;
	}
	
	public WebElement searchMsg(WebDriver driver){
		element = driver.findElement(By.className("search-msg"));
		return element;
	}
	
	public WebElement shopByCat(WebDriver driver){
		element = driver.findElements(By.id("site-navigation")).get(0);
		return element;
	}
		
	public WebElement helpandSupport(WebDriver driver){
		element = driver.findElements(By.id("site-navigation")).get(1);
		return element;
	}
		
	public WebElement christmas(WebDriver driver){
		element = driver.findElements(By.id("site-navigation")).get(2);
		return element;
	}
		
	public WebElement greatOutdoors(WebDriver driver){
		element = driver.findElements(By.id("site-navigation")).get(3);
		return element;
	}
		
	public WebElement myAccount(WebDriver driver){
		element = driver.findElement(By.id("customer_id_80240025"));
		return element;
	}
		

}
