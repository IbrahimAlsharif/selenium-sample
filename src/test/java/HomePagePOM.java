import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePagePOM {
    static public WebElement getMainTextItem(){
        return FirstWebsiteTest.driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[2]/h1"));
    }

    static public WebElement getSearchFiled(){
        return FirstWebsiteTest.driver.findElement(By.id("calcSearchTerm"));
    }

    static public WebElement getNoResultItem(){
        return FirstWebsiteTest.driver.findElement(By.id("calcSearchOut"));
    }


}
