package org.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;
    private Locator loginLink = page.locator("text=Signup / Login");

    public BasePage(Page page) {
        this.page = page;
    }

    public void clickLoginPage(){
        loginLink.click();
    }
}

