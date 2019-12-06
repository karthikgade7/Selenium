package com.omnius.app.page;

import com.omnius.app.baseScript.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentAnnotatePage extends BaseDriver {

    private final String pageLoadedText = "Click Add item to add a new item";

    private final String pageUrl = "/trainer/ui/annotate/";

    private int timeout = 15;

    @FindBy(xpath = "//chunk[contains(text(),'Sob')]/../../..//input")
    private WebElement sobInput;

    @FindBy(xpath = "//chunk[contains(text(),'Auftragsdatum')]/../../..//input")
    private WebElement auftragsdatumInput;

    @FindBy(xpath = "//chunk[contains(text(),'Rechnungsnummer')]/../../..//input")
    private WebElement rechnungsnummerInput;

    @FindBy(xpath = "//chunk[contains(text(),'Kundennummer')]/../../..//input")
    private WebElement kundennummerInput;

    @FindBy(xpath = "//chunk[contains(text(),'Vob')]/../../..//input")
    private WebElement vobInput;

    @FindBy(xpath = "//button[contains(text(),'Finalize')]")
    private WebElement finalize;

    @FindBy(xpath = "//button[contains(text(),'Reject')]")
    private WebElement reject;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    private WebElement yes;

    @FindBy(xpath = "//button[contains(text(),'No')]")
    private WebElement no;

    @FindBy(xpath = "//a[contains(text(),'Back to Document explorer')]")
    private WebElement back;

    @FindBy(xpath = "//chunk[contains(text(),'Document successfully saved.')]")
    private WebElement documentVerified;

    public DocumentAnnotatePage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify that the page loaded completely.
     */
    public DocumentAnnotatePage verifyPageLoaded() {
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
    public DocumentAnnotatePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    /**
     * set sob value.
     */
    public DocumentAnnotatePage setSobValue(String value) {
        sobInput.sendKeys(value);
        return this;
    }

    /**
     * set Auftragsdatum value.
     */
    public DocumentAnnotatePage setAuftragsdatumValue(String value) {
        auftragsdatumInput.sendKeys(value);
        return this;
    }

    /**
     * set Rechnungsnummer value.
     */
    public DocumentAnnotatePage setRechnungsnummerValue(String value) {
        rechnungsnummerInput.sendKeys(value);
        return this;
    }

    /**
     * set Kundennummer value.
     */
    public DocumentAnnotatePage setKundennummerValue(String value) {
        kundennummerInput.sendKeys(value);
        return this;
    }

    /**
     * set vob value.
     */
    public DocumentAnnotatePage setVobValue(String value) {
        vobInput.sendKeys(value);
        return this;
    }

    /**
     * Click finalize.
     */
    public DocumentAnnotatePage clickFinalize() {
        finalize.click();
        return this;
    }

    /**
     * Is finalize clickable.
     */
    public boolean isFinalizeClickable() {
        return finalize.isEnabled();
    }


    /**
     * Click yes.
     */
    public DocumentAnnotatePage clickYes() {
        yes.click();
        return this;
    }

    /**
     * Click no.
     */
    public DocumentAnnotatePage clickNo() {
        no.click();
        verifyPageLoaded();
        return this;
    }


    /**
     * Click reject.
     */
    public DocumentAnnotatePage clickReject() {
        reject.click();
        return this;
    }

    /**
     * Click back button.
     */
    public DocumentAnnotatePage clickBack() {
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(back));
        back.click();
        return this;
    }

    /**
     * Wait until document verification message.
     */
    public DocumentAnnotatePage documentVerificationMessage() {
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOf(documentVerified));
        return this;
    }



}
