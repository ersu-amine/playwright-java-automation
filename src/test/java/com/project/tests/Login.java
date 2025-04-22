package com.project.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.pages.LoginPage;
import org.utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Login {
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
        page.navigate("https://www.automationexercise.com");
        LoginPage loginPage = new LoginPage(page);
        //TODO add assertion for login page
        //assertTrue();
        //credentials masked in config.properties file
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        //TODO implement assertion
        //assertTrue(page.title().contains(""));
    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }
}
