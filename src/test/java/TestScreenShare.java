import org.junit.jupiter.api.*;
import pages.PlayerPage;
import pages.PublisherPage;
import pages.ServerPage;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestScreenShare extends BaseTest {

    PublisherPage publisherPage;
    PlayerPage playerPage;
    ServerPage serverPage;

    @Test
    @Order(1)
    public void select_screen_sharing() throws InterruptedException {
        publisherPage = new PublisherPage(driver);
        publisherPage.selectScreenSharing();
    }

    @Test
    @Order(2)
    public void start_publishing() throws InterruptedException {
        publisherPage = new PublisherPage(driver);
        publisherPage.startPublishing();
    }

    @Test
    @Order(3)
    public void get_publisher_screenshot() throws IOException, InterruptedException {
        publisherPage = new PublisherPage(driver);
        publisherPage.getScreenshot();
    }

    @Test
    @Order(4)
    public void open_player_page() throws InterruptedException {
        playerPage = new PlayerPage(driver);
        playerPage.openPlayerPage();
        playerPage.isOnPlayerPage();
        Assertions.assertTrue(playerPage.isOnPlayerPage(), "Not on Player Page");
    }

    @Test
    @Order(5)
    public void start_playing() throws InterruptedException {
        playerPage = new PlayerPage(driver);
        playerPage.startPlaying();
    }

    @Test
    @Order(6)
    public void check_screen_sharing() throws IOException, InterruptedException {
        playerPage = new PlayerPage(driver);
        playerPage.getScreenshot();
        playerPage.checkScreenSharedSuccessfully();
    }

    @Test
    @Order(7)
    public void check_screen_sharing_from_server() throws InterruptedException {
        serverPage = new ServerPage(driver);
        serverPage.openServerPage();
        serverPage.login();
        serverPage.checkIsServerPageOpened();
        Assertions.assertTrue(serverPage.checkIsServerPageOpened(), "Not on Server Page");
        serverPage.switchWebRTCPanel();
        serverPage.checkIsStreamStarted();
    }
}
