package com.project.examples;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeTest1 {
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
    void testExampleCom() {
        page.navigate("https://practicetestautomation.com/practice/");
        page.locator("//a[text()='Test Login Page']").click();
        assertTrue(page.title().contains("Test Login"));
    }

    @AfterAll
    static void teardown() {
        browser.close();
        playwright.close();
    }
}
