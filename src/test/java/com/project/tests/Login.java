package com.project.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.pages.LoginPage;
import org.utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Login{
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    void testValidLogin() {
        String url = ConfigReader.getProperty("url");
        page.navigate(url);
        LoginPage loginPage = new LoginPage(page);
        loginPage.clickLoginPage();
        Assertions.assertTrue(page.getByText("Customer Login").isVisible());
        loginPage.login();
        Assertions.assertTrue(page.getByText("My Account").isVisible());
        //TODO add logger
        System.out.println("successful login");
    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }
}
