package com.omnius.app.page;

import com.omnius.app.baseScript.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OmniusLogInPage extends BaseDriver {
    private int timeout = 15;

    private final String pageLoadedText = "";

    private final String pageUrl = "/auth/realms/omnius/protocol/openid-connect/auth";

    private final String logInErrorMessage = "Invalid username or password.";

    @FindBy(id = "kc-login")
    private WebElement logIn;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "username")
    private WebElement usernameOrEmail;

    @FindBy(xpath = "//*[@id='kc-content-wrapper']/div[1]/span[2][contains(text(),'Invalid username or password.')]")
    private WebDriver errormessage;

    public OmniusLogInPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Log In Button.
     */
    public OmniusLogInPage clickLogInButton() {
        logIn.click();
        return this;
    }


    /**
     * Set value to Password Password field.
     */
    public OmniusLogInPage setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Set value to Username Or Email Text field.
     */
    public OmniusLogInPage setUsernameOrEmailTextField(String usernameOrEmailValue) {
        usernameOrEmail.sendKeys(usernameOrEmailValue);
        return this;
    }

    /**
     * Submit the form to target page.
     */
    public OmniusLogInPage submit() {
        clickLogInButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     */
    public OmniusLogInPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     * `
     */
    public OmniusLogInPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    /**
     * Verify that the page loaded completely.
     */
    public boolean verifyLoginErrorMessage() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(logInErrorMessage);
            }
        });
        return true;
    }

    /**
     * Verify that the page Title.
     */
    public String pageTitle(){
        return driver.getTitle();
    }
}
