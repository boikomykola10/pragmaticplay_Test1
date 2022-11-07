import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class mainPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions = new Actions(driver);

    public  mainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "menu-item")
    List<WebElement> titles;

    @FindBy(className = "top-btn")
    WebElement openBtn;

    //@FindBy(xpath = "//*[@id='menu-item-1185']/a")
    WebElement homeTitle;

    @FindBy(xpath = "//*[@id='menu-item-200']/a")
    WebElement productsTitle;

    /* @FindBy(xpath = "//*[@id='menu-item-23582']/a")
    WebElement clientHubTitle;

    @FindBy(xpath = "//*[@id='menu-item-57201']/a")
    WebElement companyTitle;

    @FindBy(xpath = "//*[@id='menu-item-9841']/a")
    WebElement newsTitle;

    @FindBy(xpath = "//*[@id='menu-item-1820']/a")
    WebElement contactTitle;
*/
    @FindBy(xpath = "//*[@id='menu-item-11081']/a")
    WebElement bingoTitle;

    public void checkTheColorOnHover(WebElement element) {
        String colorBeforeHover = element.getCssValue("color");
        actions.moveToElement(element).perform();
        String colorAfterHover = element.getCssValue("color");
        Assert.assertNotEquals(colorBeforeHover, colorAfterHover);
    }

    public void openTheSite() {
        openBtn.click();
    }
    public void checkTheBingoColor() {
        actions.moveToElement(productsTitle).perform();
        String colorBingoBeforeHover = bingoTitle.getCssValue("color");
        actions.moveToElement(productsTitle).moveToElement(bingoTitle);
        String colorBingoAfterHover = bingoTitle.getCssValue("color");
        Assert.assertNotEquals(colorBingoAfterHover, colorBingoBeforeHover);

    }
}
