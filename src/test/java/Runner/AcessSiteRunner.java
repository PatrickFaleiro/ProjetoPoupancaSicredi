package Runner;

import Component.AcessSiteComponent;
import Reader.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcessSiteRunner implements AcessSiteComponent {

    public static WebDriver driver;
    public static WebDriverWait wait;
    DataReader data = new DataReader();

    public void acessSite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get(data.getConfigurationProperty("ACESS_SITE"));
        driver.manage().window().maximize();
    }

    public void exitSite(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getDriverWait(){
        return wait;
    }


}
