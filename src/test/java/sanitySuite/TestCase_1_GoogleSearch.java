package sanitySuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Syn_google_search;

import java.sql.Driver;
import java.util.List;


public class TestCase_1_GoogleSearch extends TestBase{

	private static void waitForPageLoad(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
					}
				};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}


	}
	private static WebElement getResultLink(WebDriver driver, Integer index) {
		return  driver.findElement(By.cssSelector("#rso > div:nth-child(" + index.toString() + ") > div > div > div > div > div.r > a"));
	}


	@Test
	public void searchForWinrar() {

		log.info("Open Google Search URL.");
		driver.get("https://www.google.com/");
		waitForPageLoad(driver);
		driver.findElement(By.name("q")).sendKeys("winrar");
		driver.findElement(By.name("btnK")).click();
		waitForPageLoad(driver);
		getResultLink(driver, 1).click();

	}



}
