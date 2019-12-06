package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.CollectionContext;
import com.omnius.app.script.CollectionScript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_06_CreateCollection extends BaseDriver {

    private String newCollectionName;

    @BeforeMethod
    public void login() {
        new TC_01_LoginWithValidCredentials().loginWithValidCredentials();
    }

    @Test
    public void createNewCollection() {
        CollectionContext context = new CollectionContext();
        int randomNumber = (int) (Math.random() * 10000);
        newCollectionName = "omnius_demo_" + randomNumber;
        context.setCollectionName(newCollectionName);

        CollectionScript script = new CollectionScript(context);
        script.create();
    }

    @AfterMethod
    public void searchCreatedCollection() {
        TC_05_SearchCollection search = new TC_05_SearchCollection();
        search.searchValue = newCollectionName;
        search.searchCollection();

    }

}
