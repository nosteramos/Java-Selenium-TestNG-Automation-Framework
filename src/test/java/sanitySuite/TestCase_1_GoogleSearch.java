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
		waitForPageLoad(driver);
		List<WebElement> searhResult = driver.findElements(By.cssSelector("div.g"));
		return getElementAfterItIsVisible(driver, searhResult.get(index).findElement(By.tagName("h3")));

	}
	private static WebElement getElementAfterItIsVisible(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(by));
		return element;

	}

	private static WebElement getElementAfterItIsVisible(WebDriver driver, WebElement elm) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOf(elm));
		return element;

	}



	@Test
	public void searchForWinrar() throws InterruptedException {

		log.info("Open Google Search URL.");
		driver.get("https://www.google.com/");
		waitForPageLoad(driver);
		getElementAfterItIsVisible(driver, By.name("q")).sendKeys("winrar");
		getElementAfterItIsVisible(driver, By.name("btnK")).click();
		getResultLink(driver, 2).click();
		Thread.sleep(2000);

	}



}
