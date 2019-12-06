package com.omnius.app.testCase;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.DocumentContext;
import com.omnius.app.script.DocumentScript;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_10_ValidateUploadedDocument extends BaseDriver {

    private String documentName = "dummy_file.pdf";

    @BeforeMethod
    public void loginAndSearchCollection() {
        new TC_01_LoginWithValidCredentials().loginWithValidCredentials();
        new TC_05_SearchCollection().searchCollection();
//        new TC_08_UploadDocument().uploadDocument();
        new TC_07_SearchDocument().searchDocument();
    }

    @Test
    public void validateUploadedDocument() {
        DocumentContext context = new DocumentContext();
        context.setDocumentName(documentName);
        context.setSob("Test user");
        context.setAuftragsdatum("10.11.2018");
        context.setRechnungsnummer("234434522");
        context.setKundennummer("01788922321");
        context.setVob("test data");
        context.setFinalize(true);
        DocumentScript script = new DocumentScript(context);
        script.validateDocument();
    }

}
