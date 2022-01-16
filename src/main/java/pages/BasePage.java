package pages;

import org.openqa.selenium.*;


public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver ;
    }

    public void openInNewTab(String url) {
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        newWindow.get(url);
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
}
