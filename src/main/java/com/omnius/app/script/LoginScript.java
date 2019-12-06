package com.omnius.app.script;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.LoginContext;
import com.omnius.app.page.DocumentExplorerPage;
import com.omnius.app.page.OmniusLogInPage;
import org.testng.Assert;

public class LoginScript extends BaseDriver {
    private LoginContext context;

    public LoginScript(LoginContext context) {
        this.context = context;
    }

    public void login() {
        OmniusLogInPage logInPage = new OmniusLogInPage();
        logInPage.verifyPageLoaded();
        logInPage.verifyPageUrl();
        logInPage.setUsernameOrEmailTextField(context.getUserName());
        logInPage.setPasswordPasswordField(context.getPassword());
        logInPage.clickLogInButton();

        DocumentExplorerPage explorerPage = new DocumentExplorerPage();
        Assert.assertEquals("omni:us",explorerPage.pageTitle());
    }

    public void loginFailedScenario() {
        OmniusLogInPage logInPage = new OmniusLogInPage();
        logInPage.verifyPageLoaded();
        logInPage.verifyPageUrl();
        logInPage.setUsernameOrEmailTextField(context.getUserName());
        logInPage.setPasswordPasswordField(context.getPassword());
        logInPage.clickLogInButton();
        Assert.assertTrue(logInPage.verifyLoginErrorMessage());
        Assert.assertEquals("Log in to omnius",logInPage.pageTitle());
    }
}
