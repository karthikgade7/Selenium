package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.DocumentContext;
import com.omnius.app.script.DocumentScript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TC_08_UploadDocument extends BaseDriver {

    public String newDocumentName = "dummy_file.pdf";

    @BeforeMethod
    public void loginAndSearchCollection() {
        new TC_01_LoginWithValidCredentials().loginWithValidCredentials();
        new TC_05_SearchCollection().searchCollection();
    }

    @Test
    public void uploadDocument() {
        DocumentContext context = new DocumentContext();
        context.setUploadFilePath(new File("src/main/resources/" + newDocumentName).getAbsolutePath());
        context.setValidDocument(true);
        DocumentScript script = new DocumentScript(context);
        script.uploadDocument();
    }

    @AfterMethod
    public void searchCreatedDocument() {
        TC_07_SearchDocument search = new TC_07_SearchDocument();
        search.documentName = newDocumentName;
        search.searchDocument();

    }

}
