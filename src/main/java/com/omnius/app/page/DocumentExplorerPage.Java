package com.omnius.app.page;

import com.omnius.app.baseScript.BaseDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentExplorerPage extends BaseDriver {

    private final static Logger logger = Logger.getLogger(DocumentExplorerPage.class);

    private int timeout = 15;

    private final String pageLoadedText = "Select any item from the collections table to browse the documents inside it";

    private final String pageUrl = "/trainer/ui/document-explorer";

    private String collectionName;

    private String documentName;

    @FindBy(xpath = "//button/icon[@class='iconPlus']")
    private WebElement createCollection;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement newCollectionName;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement createButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "(//input[@placeholder='Search...'])[1]")
    private WebElement searchCollections;

//    @FindBy(xpath = getFirstDocumentWithoutValidLink().)
//    private WebElement searchResultFirstItem;

//    @FindBy(xpath = "(//a[contains(text(),'dummy_file.pdf')])[1]")
//    private WebElement searchDocumentResultFirstItem;

    @FindBy(xpath = "(//input[@placeholder='Search...'])[2]")
    private WebElement searchDocument;

    @FindBy(xpath = "//button[contains(text(),'Upload')]")
    private WebElement uploadDocument;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadDocumentPath;

    @FindBy(xpath = "//chunk[contains(text(),'1 file(s) finished uploading')]")
    private WebElement uploadingFinished;

    @FindBy(xpath = "//rejected[contains(text(),'Rejected (because of type)')]")
    private WebElement failedMessage;

    @FindBy(xpath = "//succeeded[contains(text(),'Succeeded')]")
    private WebElement successMessage;

    @FindBy(xpath = "//chunk[contains(text(),'clear finished')]")
    private WebElement clearTheUpload;

    @FindBy(xpath = "//block/done")
    private WebElement uploadingStatus;

    @FindBy(xpath = "//chunk[contains(text(),'1')]/../..//platform-documents-processing-table-cell-component/img[@src='platform/omnibus/source/assets/images/check-full-green.svg']")
    private WebElement documentUploadSucceeded;

    @FindBy(xpath = "//chunk[contains(text(),'1')]/../..//platform-documents-processing-table-cell-component/img[@src='platform/omnibus/source/assets/images/problem-full-red.svg']")
    private WebElement documentUploadFailed;

    @FindBy(xpath = "(//paragraph[contains(text,'')])[2]")
    private WebElement documentCount;

    @FindBy(xpath = "(//chunk[contains(text(),'Processing')])[2]/..//img")
    private WebElement processingFilterList;

    @FindBy(xpath = "//chunk[contains(text(),'Processed')]")
    private WebElement processedFilter;

    @FindBy(xpath = "(//button[contains(text(),'Apply')])[2]")
    private WebElement apply;


    public DocumentExplorerPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Create new collection.
     */
    public DocumentExplorerPage clickCreateCollectionButton() {
        createCollection.click();
        return this;
    }

    /**
     * Set collection name.
     */
    public DocumentExplorerPage setNewCollectionName(String collectionName) {
        newCollectionName.sendKeys(collectionName);
        return this;
    }

    /**
     * Click on Create new collection button.
     */
    public DocumentExplorerPage clickCreateButton() {
        createButton.click();
        return this;
    }

    /**
     * Set collection search value in Collection search field.
     */
    public DocumentExplorerPage setCollectionSearchValue(String searchValue) {
        searchCollections.sendKeys(searchValue);
        return this;
    }

    /**
     * Set collection search value in Collection search field.
     */
    public DocumentExplorerPage setDocumentSearchValue(String searchValue) {
        searchDocument.sendKeys(searchValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     */
    public DocumentExplorerPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     */
    public DocumentExplorerPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    /**
     * Verify that the page Title.
     */
    public String pageTitle() {
        return driver.getTitle();
    }

    /**
     * Create dynamic xpath variable for collection.
     */
    public WebElement getFirstCollection() {
        String dynamicCollectionPath = "(//block[contains(text(),'%s')])[1]";
        String xpath = String.format(dynamicCollectionPath, collectionName);
        return driver.findElement(By.xpath(xpath));
    }


    /**
     * Verify collection existing or not.
     */
    public String searchResult(String collectionName) {
        this.collectionName = collectionName;
        return getFirstCollection().getText();
    }

    /**
     * Click collection search first result.
     */
    public DocumentExplorerPage clickCollectionResultOne(String collectionName) {
        this.collectionName = collectionName;
        getFirstCollection().click();
        return this;
    }

    /**
     * Create dynamic xpath variable for Document with valid type document.
     */
    public WebElement getFirstDocumentWithValidLink() {
        String dynamicDocumentPath = "(//a[contains(text(),'%s')])[1]";
        String xpath = String.format(dynamicDocumentPath, documentName);
        return driver.findElement(By.xpath(xpath));
    }


    /**
     * Create dynamic xpath variable for Document with invalid type document.
     */
    public WebElement getFirstDocumentWithoutLink() {
        String dynamicDocumentPath = "(//empty[contains(text(),'%s')])[1]";
        String xpath = String.format(dynamicDocumentPath, documentName);
        return driver.findElement(By.xpath(xpath));
    }


    /**
     * Verify document is existing or not.
     */
    public String documentSearchResultOne(String documentName, boolean resultType) {
        this.documentName = documentName;
        if (resultType) {
            return getFirstDocumentWithValidLink().getText();
        } else {
            return getFirstDocumentWithoutLink().getText();
        }
    }

    /**
     * Click document result first result.
     */
    public DocumentExplorerPage clickDocumentSearchFirstResult(String documentName) {
        this.documentName = documentName;
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(getFirstDocumentWithValidLink()));
        getFirstDocumentWithValidLink().click();
        return this;
    }

    /**
     * Click document upload button.
     */
    public DocumentExplorerPage clickDocumentUploadButton() {
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(uploadDocument));
        uploadDocument.click();
        return this;
    }

    /**
     * Upload document.
     */
    public DocumentExplorerPage uploadDocument(String filePath) {
        uploadDocumentPath.sendKeys(filePath);
        return this;
    }

    /**
     * Wait until uploading finish message.
     */
    public DocumentExplorerPage waitUntilUploadFinishedMessage() {
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(uploadingFinished));
//        clearTheUpload.click();
        return this;
    }

    /**
     * Upload valid document and waiting for the success message.
     */
    public boolean documentTypeValid() {
        Actions action = new Actions(driver);
        action.moveToElement(uploadingFinished).perform();
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(successMessage));
        return true;
    }

    /**
     * Upload invalid document and waiting for the failed message.
     */
    public boolean documentTypeInvalid() {
        Actions action = new Actions(driver);
        action.moveToElement(uploadingFinished).perform();
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(failedMessage));
        return true;
    }

    /**
     * Click wait until upload finish.
     */
    public DocumentExplorerPage waitUntilUploadFinish() {
        try {
            (new WebDriverWait(driver, 50)).until(ExpectedConditions.invisibilityOfAllElements(uploadingStatus));
        } catch (Exception e) {
            logger.debug("Document uploaded...");
        }
        return this;
    }

    /**
     * Get Document count in a Collection.
     */
    public int getDocumentCount() {
        String countValue = documentCount.getText();
        String lastWord = countValue.substring(countValue.lastIndexOf(" ") + 1);
        String value = lastWord.replace(")", "").trim();
        int count = Integer.parseInt(value);
        return count;
    }

    /**
     * Verify latest uploaded valid or not.
     */
    public boolean documentUploadingPass() {
        try {
            return driver.findElement(By.xpath("//chunk[contains(text(),'" + getDocumentCount() + "')]/../..//platform-documents-processing-table-cell-component/img[@src='platform/omnibus/source/assets/images/check-full-green.svg']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean documentUploadingFailed() {
        try {
            return driver.findElement(By.xpath("//chunk[contains(text(),'" + getDocumentCount() + "')]/../..//platform-documents-processing-table-cell-component/img[@src='platform/omnibus/source/assets/images/problem-full-red.svg']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Verify first search result valid or not.
     */
    public boolean documentProcessPass(String documentName) {
        try {
            return driver.findElement(By.xpath("(//a[contains(text(),'" + documentName + "')])[1]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean documentProcessFail(String documentName) {
        try {
            return driver.findElement(By.xpath("(//empty[contains(text(),'" + documentName + "')])[1]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public DocumentExplorerPage clickProcessingFilterList() {
        (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable(processingFilterList));
        processingFilterList.click();
        return this;
    }

    public DocumentExplorerPage clickProceedFilter() {
        processedFilter.click();
        return this;
    }

    public DocumentExplorerPage clickApply() {
        apply.click();
        return this;
    }

}
