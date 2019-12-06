package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.LoginContext;
import com.omnius.app.script.LoginScript;
import org.testng.annotations.Test;

public class TC_04_LoginWithEmptyCredentials extends BaseDriver {
    @Test
    public void loginWithEmptyCredentials() {
        LoginContext context = new LoginContext();

        context.setUserName("");
        context.setPassword("");

        LoginScript script = new LoginScript(context);
        script.loginFailedScenario();

    }

}
