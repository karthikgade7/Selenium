package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.LoginContext;
import com.omnius.app.script.LoginScript;
import org.testng.annotations.Test;

public class TC_03_LoginWithInvalidUsernameAndValidPassword extends BaseDriver {
    @Test
    public void loginWithInvalidUsernameAndValidPassword() {
        LoginContext context = new LoginContext();

        context.setUserName("InvalidUserName");
        context.setPassword("testuser");

        LoginScript script = new LoginScript(context);
        script.loginFailedScenario();

    }

}
