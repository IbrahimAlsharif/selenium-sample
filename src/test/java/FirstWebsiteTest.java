import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstWebsiteTest {
    protected static ChromeDriver driver;
    @BeforeClass
    public void setUp(){
        ChromeOptions options = new BrowserOptions().getOptions(true);
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver(options);
        driver.get("https://www.calculator.net/");
    }

    @Test
    public void verifyThatHomeIsOpenedSuccessfully(){

        Assert.assertTrue(HomePagePOM.getMainTextItem().isDisplayed());
    }

    @Test
    public void verifyThatMainTextIsCorrect(){
        String expectedString= "Free Online Calculators";
        Assert.assertEquals(HomePagePOM.getMainTextItem().getText(), expectedString);
    }

    @Test
    public void verifyThatSearchFiledIsDisplayed(){
        Assert.assertTrue(HomePagePOM.getSearchFiled().isDisplayed());
    }

    @Test
    public void verifyThatAutoSearchWorks(){
        String notFoundText="lkhsflksajflkshf";
        String expectedMessage="No calculator matches";
        HomePagePOM.getSearchFiled().sendKeys(notFoundText);
        Assert.assertTrue(HomePagePOM.getNoResultItem().getText().contains(expectedMessage));

    }

   @AfterClass
  public void tearDown(){
     driver.quit();
  }

}
