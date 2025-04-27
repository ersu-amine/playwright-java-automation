package org.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;
    private Locator signInLink;

    public BasePage(Page page) {
        this.page = page;
        this.signInLink=page.locator("//button/span[text()='Sign In']");
    }

    //private Locator signInLink = page.getByText("Sign In");

    public void clickLoginPage(){
        signInLink.click();
    }
}

