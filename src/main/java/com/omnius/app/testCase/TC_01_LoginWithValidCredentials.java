package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.LoginContext;
import com.omnius.app.script.LoginScript;
import org.testng.annotations.Test;

public class TC_01_LoginWithValidCredentials extends BaseDriver {

    public String userName;
    public String password;

    @Test
    public void loginWithValidCredentials() {
        LoginContext context = new LoginContext();
        if (userName == null & password == null) {
            userName = "testuser";
            password = "testuser";
        }

        context.setUserName(userName);
        context.setPassword(password);

        LoginScript script = new LoginScript(context);
        script.login();

    }

}
