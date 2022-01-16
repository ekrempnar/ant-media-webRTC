package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class PublisherPage extends BasePage {

    By startPublishingButtonLocator = By.id("start_publish_button");
    By optionsButtonLocator = By.id("options");
    By selectScreenButtonLocator = By.cssSelector(":nth-child(4) > :nth-child(7)");
    By videoElementLocator = By.id("localVideo");

    public PublisherPage(WebDriver driver) {
        super(driver);
    }

    public void selectScreenSharing() throws InterruptedException {
        Thread.sleep(1000);
        click(optionsButtonLocator);
        click(selectScreenButtonLocator);
        Thread.sleep(1000);
    }

    public void startPublishing() throws InterruptedException {
        Thread.sleep(1000);
        click(startPublishingButtonLocator);
        Thread.sleep(1000);
    }

    public void getScreenshot() throws IOException, InterruptedException {
        Thread.sleep(1000);
        WebElement element = find(videoElementLocator);
        Thread.sleep(4000);
        File publisherFile = element.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(publisherFile,new File("./screenshots/PublisherScreenshot.png"));
        Thread.sleep(1000);
    }
}
