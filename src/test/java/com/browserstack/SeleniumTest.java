package com.browserstack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;

public class SeleniumTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        // --- CREDENTIALS ---
        String username = "theekshanipramod_ixK9dR";
        String accessKey = "15cWy7EDqXvSpemnKgg7";
        // -------------------

        // Fix: Use ChromeOptions for W3C compliance
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("buildName", "Manual Maven Build");
        options.setCapability("bstack:options", bstackOptions);

        // Direct Connection
        String URL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
        driver = new RemoteWebDriver(new URL(URL), options);

        // Simple test
        driver.get("https://bstackdemo.com");
        System.out.println("Site Title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}