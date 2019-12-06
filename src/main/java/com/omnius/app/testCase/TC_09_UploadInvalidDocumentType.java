package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.DocumentContext;
import com.omnius.app.script.DocumentScript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TC_09_UploadInvalidDocumentType extends BaseDriver {

    private String newDocumentName = "sample_text_file.txt";

    @BeforeMethod
    public void loginAndSearchCollection() {
        new TC_01_LoginWithValidCredentials().loginWithValidCredentials();
        new TC_05_SearchCollection().searchCollection();
    }

    @Test
    public void uploadDocument() {
        DocumentContext context = new DocumentContext();
        context.setUploadFilePath(new File("src/main/resources/" + newDocumentName).getAbsolutePath());
        context.setValidDocument(false);
        DocumentScript script = new DocumentScript(context);
        script.uploadDocument();
    }

}
