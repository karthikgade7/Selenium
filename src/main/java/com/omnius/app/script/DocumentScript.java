package com.omnius.app.script;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.DocumentContext;
import com.omnius.app.page.DocumentAnnotatePage;
import com.omnius.app.page.DocumentExplorerPage;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DocumentScript extends BaseDriver {

    private final static Logger logger = Logger.getLogger(DocumentScript.class);

    private DocumentContext context;

    public DocumentScript(DocumentContext context) {
        this.context = context;
    }

    public void searchDocument() {
        DocumentExplorerPage page = new DocumentExplorerPage();
        page.verifyPageUrl();
        page.setDocumentSearchValue(context.getDocumentName());
        if (page.documentProcessPass(context.getDocumentName())) {
            Assert.assertEquals(page.documentSearchResultOne(context.getDocumentName(), true).trim(), context.getDocumentName());
        } else if (page.documentProcessFail(context.getDocumentName())) {
            Assert.assertEquals(page.documentSearchResultOne(context.getDocumentName(), false).trim(), context.getDocumentName());
        }
    }

    public void uploadDocument() {
        DocumentExplorerPage page = new DocumentExplorerPage();
        page.verifyPageUrl();
        page.clickDocumentUploadButton();
        page.uploadDocument(context.getUploadFilePath());
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        page.waitUntilUploadFinishedMessage();

        if (context.isValidDocument()) {
            Assert.assertTrue(page.documentTypeValid());
            page.waitUntilUploadFinish();
            if (page.documentUploadingPass()) {
                logger.info("DOCUMENT UPLOAD SUCCEEDED");
                System.out.println("DOCUMENT UPLOAD SUCCEEDED");
            } else if (page.documentUploadingFailed()) {
                logger.info("DOCUMENT UPLOAD FAILED");
                System.out.println("DOCUMENT UPLOAD FAILED");
            }
        } else {
            Assert.assertTrue(page.documentTypeInvalid());
        }
    }

    public void validateDocument() {
        DocumentExplorerPage page = new DocumentExplorerPage();
        page.clickProcessingFilterList();
        page.clickProceedFilter();
        page.clickApply();
        page.clickProcessingFilterList();
        page.clickDocumentSearchFirstResult(context.getDocumentName());
        DocumentAnnotatePage annotatePage = new DocumentAnnotatePage();
        annotatePage.verifyPageLoaded();
        annotatePage.verifyPageUrl();
        annotatePage.setSobValue(context.getSob());
        annotatePage.setAuftragsdatumValue(context.getAuftragsdatum());
        annotatePage.setVobValue(context.getVob());
        annotatePage.setKundennummerValue(context.getKundennummer());
        annotatePage.setRechnungsnummerValue(context.getRechnungsnummer());
        if (context.isFinalize()) {
            annotatePage.clickFinalize();
        } else {
            annotatePage.clickReject();
        }
        annotatePage.clickYes();
        annotatePage.verifyPageLoaded();
        annotatePage.documentVerificationMessage();
        annotatePage.clickBack();


    }
}
