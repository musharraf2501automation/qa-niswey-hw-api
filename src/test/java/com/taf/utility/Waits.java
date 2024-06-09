package com.taf.utility;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Waits {
    @Step("waits for alert and accepts it")
    public void waitForAlertAndAccept(WebDriver driver) {
        waitForAlert();
        driver.switchTo().alert().accept();
    }
    @Step("waits for {0} to be not visible")
    public void waitUntilNotVisible(WebElementFacade element) {
        element.waitUntilNotVisible();
    }

    @Step("waits for alert and cancel it")
    public void waitForAlertAndCancel() {
        waitForAlert();
        getDriver().switchTo().alert().dismiss();
    }

    @Step("waits for alert")
    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("waits for {0} to be present")
    public void waitUntilPresent(WebElementFacade element) {
        element.waitUntilPresent();
    }

    @Step("waits for {0} to be clickable")
    public void waitUntilClickable(WebElementFacade element) {
        element.waitUntilClickable();
    }

    @Step("waits for {0} to be enabled")
    public void waitUntilEnabled(WebElementFacade element) {
        element.waitUntilEnabled();
    }

    @Step("waits for {0} to be visible")
    public void waitUntilVisible(WebElementFacade element) {
        element.waitUntilVisible();
    }
}
