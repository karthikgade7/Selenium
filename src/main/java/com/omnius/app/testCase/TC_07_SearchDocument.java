package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.DocumentContext;
import com.omnius.app.script.DocumentScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_07_SearchDocument extends BaseDriver {

    public String documentName = "dummy_file.pdf";

    @BeforeMethod
    private void loginAndSearchCollection() {
        new TC_01_LoginWithValidCredentials().loginWithValidCredentials();
        TC_05_SearchCollection searchCollection = new TC_05_SearchCollection();
        searchCollection.searchValue = "omnius_demo";
        searchCollection.searchCollection();
    }


    @Test
    public void searchDocument() {
        DocumentContext context = new DocumentContext();
        if (documentName == null) {
            documentName = "dummy.pdf";
        }
        context.setDocumentName(documentName);

        DocumentScript script = new DocumentScript(context);
        script.searchDocument();
    }

}
