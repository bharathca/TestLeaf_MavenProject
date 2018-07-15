package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {
		try {

			switch (locator) {

			case "id":
				reportSteps("The element with locator "+locator+" and the locator value "+locValue+" is located","pass"); 
				return driver.findElement(By.id(locValue));

			case "class":
				reportSteps("The element with locator "+locator+" and the locator value "+locValue+" is located","pass"); 
				return driver.findElement(By.className(locValue));

			case "link" :
				reportSteps("The element with locator "+locator+" and the locator value "+locValue+" is located","pass"); 
				return driver.findElement(By.linkText(locValue));
				//partial
				//cssselector

			case "xpath" :
				reportSteps("The element with locator "+locator+" and the locator value "+locValue+" is located","pass");
				return driver.findElement(By.xpath(locValue));

			case "name" :
				reportSteps("The element with locator "+locator+" and the locator value "+locValue+" is located","pass");
				return driver.findElement(By.name(locValue));

			default: 
				reportSteps("The element with locator "+locator+" is not there in the switch case","fail");
				break;
			}
		} catch (NoSuchElementException e) {
			reportSteps("The element with locator "+locator+" and the locator value "+locValue+" is having issues and is not located","fail");
			throw new RuntimeException("NoSuchElementException");
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportSteps("The Data "+data+" is Entered Successfully", "pass");
		}catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("The Data "+data+" is not Entered Successfully", "fail");
			throw new RuntimeException("NoSuchElementException or InvalidElementStateException");
		}		

	}

	public void click(WebElement ele) {
		try { 
			ele.click();
			reportSteps("The Element "+ele+" is clicked Successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("The Element "+ele+" is not found or not editable","fail");
			throw new RuntimeException("NoSuchElementException or InvalidElementStateException");			
		}	
	}

	public String getText(WebElement ele) {
		try {
			String eleText = ele.getText();
			reportSteps("The Element "+ele+" gets the text Successfully", "pass");
			return eleText;
		} catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("Element "+ele+" is not found or not editable","fail");
			throw new RuntimeException("NoSuchElementException");
		}

	}

	public void clear(WebElement ele){
		try {
			ele.clear();
			reportSteps("Element "+ele+" is found and cleared","pass");
		}
		catch (NoSuchElementException e) {
			reportSteps("Element "+ele+" is not found","fail");
			throw new RuntimeException("NoAlertPresentException");
		}

	}
	public void clearAndType(WebElement ele, String data) {

		try {
			driver.unregister(this);
			ele.clear();

			driver.register(this);
			ele.sendKeys(data);
			reportSteps("Element "+ele+" is found,cleared and typed","pass");
		} catch (Exception e) {
			reportSteps("Element "+ele+" is not found,cleared and typed","fail");
			throw new RuntimeException("NoElementPresentException");
		}

	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(ele));
			//make the below as global variable
			Select selectObject=new Select(ele);
			selectObject.selectByVisibleText(value);
			reportSteps("The Element "+ele+" with value "+value+" is selected successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("The Element "+ele+" with value "+value+" is not selected", "fail");
			throw new RuntimeException("NoSuchElementException or InvalidElementStateException");
		}

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Select selectObject=new Select(ele);
			selectObject.selectByValue(value);
			reportSteps("The Element "+ele+" with value "+value+" is selected successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException e) {
			reportSteps("The Element "+ele+" with value "+value+" is not selected", "fail");
			throw new RuntimeException("NoSuchElementException or InvalidElementStateException");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select selectObject = new Select(ele);
			selectObject.selectByIndex(index);
			reportSteps("The Element "+ele+" with index "+index+" is selected successfully", "pass");
		} catch (NoSuchElementException | InvalidElementStateException | IndexOutOfBoundsException e) {
			reportSteps("The Element "+ele+" with index "+index+" is not selected", "fail");
			throw new RuntimeException("NoSuchElementException or IndexOutOfBoundException or InvalidElementStateException");
		}	

	}

	public boolean verifyExactTitle(String expectedTitle) {

		if(driver.getTitle().equals(expectedTitle)){
			reportSteps("The expected title "+expectedTitle+" is matching the title", "pass");
			return true;
		}
		else {
			reportSteps("The expected title "+expectedTitle+" is not matching the title", "fail");
			return false;	
		}
	}

	public boolean verifyPartialTitle(String expectedTitle) {

		if(driver.getTitle().contains(expectedTitle)){
			reportSteps("The expected title "+expectedTitle+" is matching the title partially", "pass");
			return true;
		}
		else {
			reportSteps("The expected title "+expectedTitle+" is not matching the title partially", "fail");
			return false;	
		}


	}

	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)){
			reportSteps("The expected value "+expectedText+" is matching the given value", "pass");
		}
		else {
			reportSteps("The expected value "+expectedText+" is not matching the given value", "fail");

		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)){
			reportSteps("The expected value "+expectedText+" is matching the given value partially", "pass");

		}
		else {
			reportSteps("The expected value "+expectedText+" is not matching the given value partially", "fail");

		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {

		if(ele.getAttribute(attribute).equals(value)) {
			reportSteps("The expected attribute "+ele.getAttribute(attribute)+" is matching the given value ", "pass");
		}else {
			reportSteps("The expected attribute "+ele.getAttribute(attribute)+" is not matching the given value ", "fail");		}
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).contains(value)) {
			reportSteps("The expected attribute "+ele.getAttribute(attribute)+" is matching the given value partially", "pass");
		}else {
			reportSteps("The expected attribute "+ele.getAttribute(attribute)+" is not matching the given value partially", "fail");		}
	}


	public void verifySelected(WebElement ele) {
		if(ele.isSelected()) {
			reportSteps(ele+" is Selected","pass");
		}
		else {
			reportSteps(ele+" is not Selected","fail");		}
	}

	public void verifyDisplayed(WebElement ele) {
		if(ele.isDisplayed()) {
			reportSteps(ele+" is displayed","pass");
		}
		else {
			reportSteps(ele+" is displayed","fail");
		}
	}

	public void switchToWindow(int index) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindowHandles = new ArrayList<String>();
		listWindowHandles.addAll(windowHandles);
		driver.switchTo().window(listWindowHandles.get(index));


		/*
		try {
			Set<String> allwindowHandles = driver.getWindowHandles();
			List<String> list = new ArrayList<String>();
			System.out.println(list.size());
			list.addAll(allwindowHandles);
			driver.switchTo().window(list.get(index));
		} catch (NoSuchWindowException e) {
			System.err.println("NoSuchWindowException");
			throw new RuntimeException();
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException");
			throw new RuntimeException();
		}*/
	}

	public void switchToFrame(WebElement ele){
		//write for switch to frame by element, byname or index
		driver.switchTo().frame(ele);
	}
	
	public void keyboard(String key)
	{

		Actions select= new Actions(driver);
		select.keyDown(Keys.ESCAPE);
	}

	public void acceptAlert(){
		try {
			driver.switchTo().alert().accept();
			reportSteps("The Alert text is accepted", "pass");
		} catch (NoAlertPresentException e) {
			reportSteps("No Alert present to accept","fail");
			throw new RuntimeException("NoAlertPresentException");
		}
	}

	public void dismissAlert(){
		try {
			driver.switchTo().alert().dismiss();
			reportSteps("The Alert text is dismissed", "pass");
		} catch (NoAlertPresentException e) {
			reportSteps("No Alert present to accept","fail");
			throw new RuntimeException("NoAlertPresentException");
		}
	}
	
	public void acceptAlert(String data) {

		try {
			driver.switchTo().alert().sendKeys(data);
			driver.switchTo().alert().accept();
			reportSteps("The Alert is given with data and accepted ", "pass");
		}
		catch (Exception e) {
			reportSteps("The Alert is not given with data and is not accepted ", "fail");
			throw new RuntimeException("NoAlertPresentException");
		}
	}
	
	public String getAlertText(){
		try {
			String eleAlertText = driver.switchTo().alert().getText();
			reportSteps("The Alert text is "+eleAlertText, "pass");
			return eleAlertText;
		} catch (NoAlertPresentException e) {
			reportSteps("There is  no alert text is present ", "fail");
			throw new RuntimeException("NoAlertPresentException");
		}
	}

	public void closeActiveBrowser() {
		driver.close();
	}

	public void closeAllBrowsers() {
		driver.quit();		
	}

	public void actions(WebElement ele){
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).build().perform();
	}
}
