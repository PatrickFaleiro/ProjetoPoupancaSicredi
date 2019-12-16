package Runner;

import Component.AcessoSiteComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcessoSiteRunner implements AcessoSiteComponent {

    //Acesso ao site
    private static final String CHROME_DRIVER = "C:\\webdriver\\chromedriver.exe";
    private static final String HTTP_SITE = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void acessoSite(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get(HTTP_SITE);
        driver.manage().window().maximize();
    }

    public void sairSite(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getDriverWait(){
        return wait;
    }


}
