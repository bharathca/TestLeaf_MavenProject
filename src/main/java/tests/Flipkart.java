package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

	public class Flipkart extends WebDriverServiceImpl {
		// TODO Auto-generated method stub
		@Test
		public void flipkart() throws InterruptedException {
			
			WebElement closePopUp = locateElement("xpath", "//button[text() = '✕']");
			click(closePopUp);			
			
			WebElement tvAppliances = locateElement("xpath", "(//span[text() = 'TVs & Appliances'])");
			actions(tvAppliances);
					
			
			Thread.sleep(5000);
			
			
			
			
			WebElement samsung = locateElement("xpath", "(//span[text() = 'Samsung'])[2]");
			click(samsung);
			
			Thread.sleep(5000);
			WebElement minPrice = locateElement("xpath", "(//select[@class = 'fPjUPw'])[1]");
			selectDropDownUsingValue(minPrice,"25000");
			Thread.sleep(5000);
			WebElement maxPrice = locateElement("xpath", "(//select[@class = 'fPjUPw'])[2]");
			selectDropDownUsingValue(maxPrice,"60000");
			Thread.sleep(5000);
			WebElement screenSize = locateElement("xpath", "(//div[text() ='Screen Size'])");
			Thread.sleep(5000);
			click(screenSize);
			Thread.sleep(5000);
			WebElement size = locateElement("xpath", "(//div[text() = '48 - 55'])");
			click(size);
			Thread.sleep(5000);
			
			WebElement checkCurrentWindowPrice = locateElement("xpath", "(//div[@class = '_1vC4OE _2rQ-NK'])[1]");
			String price1 = checkCurrentWindowPrice.getText();
			WebElement firstLink = locateElement("xpath", "(//div[@class = '_3wU53n'])[1]");
			click(firstLink);
			switchToWindow(1);
			
			WebElement checkPrice = locateElement("xpath", "(//div[@class = '_1vC4OE _3qQ9m1'])");
			String price2 = checkPrice.getText();
			
			if(price1.equals(price2))
			{
				System.out.println("The prices are correct");
			}
			else
			{
				System.out.println("The prices are not correct");
			}
			closeActiveBrowser();
			switchToWindow(0);
			WebElement compare1 = locateElement("xpath", "(//span[text()= 'Add to Compare'])[1]");
			click(compare1);
			Thread.sleep(5000);
			WebElement compare2 = locateElement("xpath", "(//span[text()= 'Add to Compare'])[2]");
			click(compare2);
			Thread.sleep(5000);
			
			WebElement compare = locateElement("xpath", "(//span[text()= 'COMPARE'])");
			click(compare);
			Thread.sleep(5000);
			WebElement valueCompare = locateElement("xpath", "(//span[text()= 'Compare'])");
			String value = valueCompare.getText();
			String compareSectionTitle = "Compare";
			if(value.equals(compareSectionTitle))
			{
				System.out.println("The Compare appears as section title");
			}
			else
			{
				System.out.println("The Compare is not appearing as section title");
			}
			WebElement comparePrice1 = locateElement("xpath", "(//div[@class = '_1vC4OE'])[1]");
			String compPrice1 = comparePrice1.getText();
			WebElement comparePrice2 = locateElement("xpath", "(//div[@class = '_1vC4OE'])[2]");
			String compPrice2 = comparePrice2.getText();
			
			String compareePrice1 = compPrice1.replaceAll("\\D", "");
			

			
			String compareePrice2 = compPrice2.replaceAll("\\D", "");
					
			int intPrice1 = Integer.parseInt(compareePrice1);
			int intPrice2 = Integer.parseInt(compareePrice2);
			
			if(intPrice1>intPrice2)
			{
				System.out.println("The price of second is lowest"+intPrice2);
			}
			else
			{
				System.out.println("The price of first is lowest"+intPrice1);
			}
			
			
	}

}
