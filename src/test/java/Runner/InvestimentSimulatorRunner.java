package Runner;

import Component.InvestimentSimulatorComponent;
import Reader.DataReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DecimalFormat;
import java.util.Random;

public class InvestimentSimulatorRunner implements InvestimentSimulatorComponent {


    DataReader data = new DataReader();

    private static String geraValorRandomico(int min, int max) {

        DecimalFormat formato = new DecimalFormat("0.00");
        if (min >= max) {
            throw new IllegalArgumentException("valor máximo deve ser maior que o mínimo");
        }

        Random numeroRandomico = new Random();
        return formato.format(numeroRandomico.nextInt((max - min) + 1) + min);
    }

    public void insertApplicationValue() {

        AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("APPICATION_VALUE"))).sendKeys(geraValorRandomico(20, 100));

    }

    public void insertSavingsValue() {
        AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("SAVINGS_MONTH_VALUE"))).sendKeys(geraValorRandomico(20, 100));
    }

    public void insertSavingPeriod() {
        AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("SAVINGS_PERIOD"))).sendKeys(geraValorRandomico(1, 12));
    }

    public void clickButtonOk() {
        AcessSiteRunner.getDriver().findElement(By.className(data.getConfigurationProperty("SIMULATION_BUTTON"))).click();
    }

    public void validateSucessSimulation() {
        AcessSiteRunner.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.className(data.getConfigurationProperty("SIMULATION_RESULT_BLOCK"))));
        Assert.assertNotNull(data.getConfigurationProperty("SIMULATION_VALUE_RESULT_TOTAL_VALUE"));
    }

    public void returnSimulationPage(){
        AcessSiteRunner.getDriver().findElement(By.xpath(data.getConfigurationProperty("RETURN_SIMULATION_PAGE"))).click();
    }

    public void insertValueLowerThanTwentyReaisOnApplicationField(){
        AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("APPICATION_VALUE"))).sendKeys(geraValorRandomico(0, 19));
    }

    public void insertValeuLowerThanTwentyReaisOnSavingsField(){
        AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("SAVINGS_MONTH_VALUE"))).sendKeys(geraValorRandomico(0, 19));
    }

    public void exitApplicationField(){
        AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("APPICATION_VALUE"))).sendKeys(Keys.TAB);
    }

    public void exitSavingsField(){
        AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("SAVINGS_MONTH_VALUE"))).sendKeys(Keys.TAB);
    }

    public void validateMessageApplicationFieldLowerThanTwentyReais(){
        Assert.assertEquals("Valor mínimo de 20.00", AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("APPLICATION_ERROR_MESSAGE"))).getText());
    }

    public void validateMessageSavingsFieldLowerThanTwentyReais(){
        Assert.assertEquals("Valor mínimo de 20.00", AcessSiteRunner.getDriver().findElement(By.id(data.getConfigurationProperty("SAVINGS_ERROR_MESSAGE"))).getText());
    }

}
