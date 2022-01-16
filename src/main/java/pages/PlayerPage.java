package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerPage extends BasePage {

    String playerURL = "https://ovh36.antmedia.io:5443/WebRTCAppEE/player.html";
    By startPlayerButtonLocator = By.id("start_play_button");
    By videoElementLocator = By.id("start_play_button");

    public PlayerPage(WebDriver driver) {
        super(driver);
    }

    public void openPlayerPage() throws InterruptedException {
        Thread.sleep(1000);
        openInNewTab(playerURL);
        Thread.sleep(1000);
    }

    public boolean isOnPlayerPage() throws InterruptedException {
        Thread.sleep(1000);
        return isDisplayed(startPlayerButtonLocator);
    }

    public void startPlaying() throws InterruptedException {
        Thread.sleep(1000);
        click(startPlayerButtonLocator);
        Thread.sleep(1000);
    }

    public void getScreenshot() throws IOException, InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.cssSelector("#remoteVideo"));
        Thread.sleep(2000);
        File playerFile = element.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(playerFile,new File("./screenshots/PlayerScreenshot.png"));
        Thread.sleep(1000);
    }

    public void checkScreenSharedSuccessfully(){
        WebElement video = find(videoElementLocator);
        if (video.isEnabled())
        {
            System.out.println("Screen sharing failed");
            fail("Screen sharing failed");
        }else {
            System.out.println("Screen shared successfully");
            assertTrue(true,"Screen shared successfully");
        }
    }



}
