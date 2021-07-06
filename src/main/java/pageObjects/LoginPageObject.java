package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	public void inputValueToField(String typeValue, String dataValue) {
		waitForElementClickable(LoginPageUI.TEXTBOX_BY_TYPE, typeValue);
		sendKeyToELement(LoginPageUI.TEXTBOX_BY_TYPE, dataValue, typeValue);
	}

	public boolean isNonExistPhoneErrorDisplayed(String errorPhone) {
		waitForElementVisible(LoginPageUI.TEXTBOX_BY_TYPE_ERROR_MESSAGE, "tel", errorPhone);
		return isElementDisplayed(LoginPageUI.TEXTBOX_BY_TYPE_ERROR_MESSAGE, "tel", errorPhone);
	}

	public String isLoginPageContent() {
		waitForElementVisible(LoginPageUI.WELCOME_LOGIN_PAGE_CONTENT);
		return getTextElement(LoginPageUI.WELCOME_LOGIN_PAGE_CONTENT);
	}

}
