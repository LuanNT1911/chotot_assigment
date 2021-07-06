package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	private WebDriverWait explicitWait;
	private long long_timeOut = 15;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	private String getDynamicLocator(String dynamicLocator, String... param) {
		return String.format(dynamicLocator, (Object[]) param);
	}

	private By getByXpath(String xpath) {
		return By.xpath(xpath);
	}

	private WebElement getWebElement(String locator) {
		return driver.findElement(getByXpath(locator));
	}

	protected String getTextElement(String locator) {
		return getWebElement(locator).getText();
	}

	protected String getTextElement(String dynamicLocator, String... param) {
		String locator = getDynamicLocator(dynamicLocator, param);
		return getWebElement(locator).getText();
	}

	protected void clickToELement(String locator) {
		getWebElement(locator).click();
	}
	
	protected void sendKeyToELement(String dynamicLocator, String value, String... param) {
		String locator = getDynamicLocator(dynamicLocator, param);
		getWebElement(locator).sendKeys(value);
	}

	protected void waitForElementVisible(String locator) {
		explicitWait = new WebDriverWait(driver, long_timeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	protected void waitForElementVisible(String dynamicLocator, String... param) {
		String locator = getDynamicLocator(dynamicLocator, param);
		explicitWait = new WebDriverWait(driver, long_timeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	protected void waitForElementClickable(String locator) {
		explicitWait = new WebDriverWait(driver, long_timeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	protected void waitForElementClickable(String dynamicLocator, String... param) {
		String locator = getDynamicLocator(dynamicLocator, param);
		explicitWait = new WebDriverWait(driver, long_timeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	protected boolean isElementDisplayed(String dynamicLocator, String... param) {
		String locator = getDynamicLocator(dynamicLocator, param);
		return getWebElement(locator).isDisplayed();
	}
}
