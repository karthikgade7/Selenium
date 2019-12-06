package com.omnius.app.script;

import com.omnius.app.baseScript.BaseDriver;
import com.omnius.app.context.CollectionContext;
import com.omnius.app.page.DocumentExplorerPage;
import org.testng.Assert;

public class CollectionScript extends BaseDriver {
    private CollectionContext context;

    public CollectionScript(CollectionContext context) {
        this.context = context;
    }

    public void search() {
        DocumentExplorerPage page = new DocumentExplorerPage();
        page.verifyPageLoaded();
        page.verifyPageUrl();
        page.setCollectionSearchValue(context.getCollectionName());
        page.verifyPageLoaded();
        page.clickCollectionResultOne(context.getCollectionName());
        Assert.assertEquals(page.searchResult(context.getCollectionName()).trim(), context.getCollectionName());
    }

    public void create() {
        DocumentExplorerPage page = new DocumentExplorerPage();
        page.verifyPageLoaded();
        page.verifyPageUrl();
        page.clickCreateCollectionButton();
        page.setNewCollectionName(context.getCollectionName());
        page.clickCreateButton();
        page.verifyPageLoaded();
    }
}
