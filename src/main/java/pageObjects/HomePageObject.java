package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{

	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	public void clickOnLoginButton() {
		waitForElementClickable(HomePageUI.LOGIN_BUTTON);
		clickToELement(HomePageUI.LOGIN_BUTTON);
	}

}
