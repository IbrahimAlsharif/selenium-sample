import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstWebsiteTest {
    protected static ChromeDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        ChromeOptions options = new BrowserOptions().getOptions(true);
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver(options);
        wait=new WebDriverWait(driver, 20);
        driver.get("https://www.calculator.net/");
    }

    @Test
    public void verifyThatHomeIsOpenedSuccessfully(){
        wait.until(ExpectedConditions.visibilityOf(HomePagePOM.getMainTextItem()));
        Assert.assertTrue(HomePagePOM.getMainTextItem().isDisplayed());
    }

    @Test
    public void verifyThatMainTextIsCorrect(){
        String expectedString= "Free Online Calculators";
        wait.until(ExpectedConditions.visibilityOf(HomePagePOM.getMainTextItem()));
        Assert.assertEquals(HomePagePOM.getMainTextItem().getText(), expectedString);
    }

    @Test
    public void verifyThatSearchFiledIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(HomePagePOM.getSearchFiled()));
        Assert.assertTrue(HomePagePOM.getSearchFiled().isDisplayed());
    }

    @Test
    public void verifyThatAutoSearchWorks(){
        String notFoundText="lkhsflksajflkshf";
        String expectedMessage="No calculator matches";
        wait.until(ExpectedConditions.visibilityOf(HomePagePOM.getSearchFiled()));
        HomePagePOM.getSearchFiled().sendKeys(notFoundText);
        Assert.assertTrue(HomePagePOM.getNoResultItem().getText().contains(expectedMessage));
    }

   @AfterClass
  public void tearDown(){
        driver.quit();
  }

}
