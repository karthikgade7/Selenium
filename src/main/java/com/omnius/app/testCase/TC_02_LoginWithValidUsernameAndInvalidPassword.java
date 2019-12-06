package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.LoginContext;
import com.omnius.app.script.LoginScript;
import org.testng.annotations.Test;

public class TC_02_LoginWithValidUsernameAndInvalidPassword extends BaseDriver {
    @Test
    public void loginWithInvalidPasswordAndValidUsername() {
        LoginContext context = new LoginContext();

        context.setUserName("testuser");
        context.setPassword("invalidPassword");

        LoginScript script = new LoginScript(context);
        script.loginFailedScenario();

    }

}
