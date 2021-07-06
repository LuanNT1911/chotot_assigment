package chotot.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;

public class Login_via_Mobile_Number extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	String loginPageContent = "Chào bạn quay lại";
	String phone;
	String password;
	String errorPhone = "Không tìm thấy thông tin người dùng.";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = getBrowserDriver(browser, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		log.info("Login 01-Precondition 01: Click on 'Đăng Nhập' button.");
		homePage.clickOnLoginButton();

		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		log.info("Login 01-Precondition 02: Login page is displayed");
		verifyEquals(loginPage.isLoginPageContent(), loginPageContent);
	}
	
//	@Test
	public void Login_01_Using_Valid_Mobile_Number_And_Valid_Password() {
		
	}

	@Test
	public void Login_02_Using_Invalid_Mobile_Number_And_Valid_Password() {
		phone = "luanNguyen";
		password = "1234567";
		
		log.info("Login 02 - Step 01: Input data into 'Nhập SĐT của bạn': " + phone);
		loginPage.inputValueToField("tel", phone);
		
		log.info("Login 02 - Step 02: Input data into 'Nhập mật khẩu của bạn': " + password);
		loginPage.inputValueToField("password", password);
		
		log.info("Login 02 - Step 03: Verify the error message of the mobile phone is displayed: " + errorPhone);
		verifyTrue(loginPage.isNonExistPhoneErrorDisplayed(errorPhone));
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
