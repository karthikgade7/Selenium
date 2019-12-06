package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.CollectionContext;
import com.omnius.app.script.CollectionScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_05_SearchCollection extends BaseDriver {

    String searchValue;

    @BeforeMethod
    private void login() {
        TC_01_LoginWithValidCredentials login = new TC_01_LoginWithValidCredentials();
        login.password = "testuser";
        login.userName = "testuser";
        login.loginWithValidCredentials();
    }

    @Test
    public void searchCollection() {
        CollectionContext context = new CollectionContext();
        if (searchValue == null) {
            searchValue = "omnius_demo";
        }
        context.setCollectionName(searchValue);

        CollectionScript script = new CollectionScript(context);
        script.search();

    }

}
