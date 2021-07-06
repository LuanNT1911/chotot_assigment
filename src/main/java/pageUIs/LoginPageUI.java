package pageUIs;

public class LoginPageUI {
	public static final String WELCOME_LOGIN_PAGE_CONTENT = "//*[@id='__next']//h3/following-sibling::p";
	public static final String TEXTBOX_BY_TYPE = "//input[@type='%s']";
	public static final String LOGIN_BUTTON = "//button[@type='submit']";
	public static final String TEXTBOX_BY_TYPE_ERROR_MESSAGE = "//input[@type='%s']/parent::div/following-sibling::p[text()='%s']";
}
