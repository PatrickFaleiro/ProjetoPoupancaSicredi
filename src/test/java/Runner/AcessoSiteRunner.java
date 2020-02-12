package Runner;

import Component.AcessoSiteComponent;
import Reader.LeituraDados;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcessoSiteRunner implements AcessoSiteComponent {

    public static WebDriver driver;
    public static WebDriverWait wait;
    LeituraDados dados = new LeituraDados();

    public void acessoSite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get(dados.pegaAcessoPagina());
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
