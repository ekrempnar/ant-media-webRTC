package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ServerPage extends BasePage{

    String serverURL = "https://ovh36.antmedia.io:5443/";
    By userName = By.cssSelector(":nth-child(2) > .form-control");
    By psw = By.cssSelector(":nth-child(3) > .form-control");
    By letsGoButton = By.className("btn");
    By logoText = By.className("logo-normal");
    By streamName = By.className("mat-sort-header-content");
    By webRTCApp = By.cssSelector(":nth-child(2) > a > .sidebar-normal");

    public ServerPage(WebDriver driver) {
        super(driver);
    }

    public void openServerPage() {
        openInNewTab(serverURL);
    }

    public void login() throws InterruptedException {
        Thread.sleep(2000);
        WebElement username = find(userName);
        WebElement password = find(psw);
        WebElement login = find(letsGoButton);

        username.sendKeys("test@antmedia.io");
        password.sendKeys("testtest");
        login.click();
        Thread.sleep(2000);
    }

    public boolean checkIsServerPageOpened() throws InterruptedException {
        Thread.sleep(2000);
        return isDisplayed(logoText);
    }

    public void switchWebRTCPanel() throws InterruptedException {
        Thread.sleep(2000);
        click(webRTCApp);
        Thread.sleep(2000);
    }

    public void checkIsStreamStarted() {
        WebElement stream = find(streamName);
        if (!stream.isDisplayed())
        {
            fail("Screen sharing failed");
        }else {
            assertTrue(true,"Screen sharing failed");
        }
    }
}
