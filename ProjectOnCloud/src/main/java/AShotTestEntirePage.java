import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class AShotTestEntirePage {

    private static ChromeDriver driver;

	public static void main(String[] args) throws Exception {

    	System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

        driver.get("https://unmesh.me/2013/02/06/ios-automation-with-appium/");
        Thread.sleep(5000);
        (new WebDriverWait(driver, 30))
                .until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver newDriver) {
                        return newDriver.findElement(By.linkText("QTP Cookbook"));
                    }
                });

        final Screenshot screenshot = new AShot().shootingStrategy(
                new ViewportPastingStrategy(500)).takeScreenshot(driver);
        final BufferedImage image = screenshot.getImage();
        ImageIO.write(image, "PNG", new File(
                "D://"
                        + "AShot_BBC_Entire.png"));

        driver.quit();
    }
}