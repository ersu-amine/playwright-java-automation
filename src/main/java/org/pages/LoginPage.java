package org.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.utils.ConfigReader;

public class LoginPage extends BasePage{

    private Locator usernameInput;
    private Locator passwordInput;
    private Locator submitButton;

    public LoginPage(Page page) {
        super(page);
        this.usernameInput = page.locator("name='login[username]'");
        this.passwordInput = page.locator("name='login[password]'");
        this.submitButton = page.locator("//button/span[text()='Sign In']");
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        submitButton.click();
    }

    public void login() {
        usernameInput.fill(ConfigReader.getProperty("username"));
        passwordInput.fill(ConfigReader.getProperty("password"));
        submitButton.click();
    }


}
