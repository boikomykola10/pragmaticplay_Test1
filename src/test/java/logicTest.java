import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class logicTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.pragmaticplay.com/en");
    }

    @Test
    public void testCase1() {
        mainPage mainPage = new mainPage (driver, wait);
        mainPage.openTheSite();
        for (WebElement element: mainPage.titles) {
            mainPage.checkTheColorOnHover(element);
        }
        mainPage.checkTheColorOnHover(mainPage.productsTitle);
        mainPage.checkTheBingoColor();
    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
