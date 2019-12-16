package Runner;

import Component.SimuladorInvestimentosComponent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DecimalFormat;
import java.util.Random;

public class SimuladorInvestimentosRunner implements SimuladorInvestimentosComponent {

    private static final String VALOR_APLICACAO = "valorAplicar";
    private static final String VALOR_POUPANCA_MES = "valorInvestir";
    private static final String QUANTIDADE_TEMPO_POUCANCA = "tempo";
    private static final String BOTAO_SIMULAR = "simular";
    private static final String BLOCO_RESULTADO_SIMULACAO = "blocoResultadoSimulacao";
    private static final String VALOR_TOTAL_RESULTADO_SIMULACAO = "valor";
    private static final String BOTAO_RETORNAR_PAGINA_SIMULACAO = "//*[contains(@class,'blocoResultadoSimulacao')]/a";
    private static final String ERRO_VALOR_APLICACAO = "valorAplicar-error";
    private static final String ERRO_VALOR_A_POUPAR = "valorInvestir-error";

    private static String geraValorRandomico(int min, int max) {

        DecimalFormat format = new DecimalFormat("0.00");
        if (min >= max) {
            throw new IllegalArgumentException("valor máximo deve ser maior que o mínimo");
        }

        Random r = new Random();
        return format.format(r.nextInt((max - min) + 1) + min);
    }

    public void inserirValorDeAplicacao() {

        AcessoSiteRunner.getDriver().findElement(By.id(VALOR_APLICACAO)).sendKeys(geraValorRandomico(20, 100));

    }

    public void inserirValorAPoupar() {
        AcessoSiteRunner.getDriver().findElement(By.id(VALOR_POUPANCA_MES)).sendKeys(geraValorRandomico(20, 100));
    }

    public void inserirTempoDePoupanca() {
        AcessoSiteRunner.getDriver().findElement(By.id(QUANTIDADE_TEMPO_POUCANCA)).sendKeys(geraValorRandomico(1, 12));
    }

    public void clicarBotaoOK() {
        AcessoSiteRunner.getDriver().findElement(By.className(BOTAO_SIMULAR)).click();
    }

    public void validarSimulacaoComSucesso() {
        AcessoSiteRunner.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.className(BLOCO_RESULTADO_SIMULACAO)));
        Assert.assertNotNull(VALOR_TOTAL_RESULTADO_SIMULACAO);
    }

    public void retornarPaginaSimulacao(){
        AcessoSiteRunner.getDriver().findElement(By.xpath(BOTAO_RETORNAR_PAGINA_SIMULACAO)).click();
    }

    public void inserirValorInferiorAVinteReaisValorAplicacao(){
        AcessoSiteRunner.getDriver().findElement(By.id(VALOR_APLICACAO)).sendKeys(geraValorRandomico(0, 19));
    }

    public void inserirValorInferiorAVinteReaisValorAPoupar(){
        AcessoSiteRunner.getDriver().findElement(By.id(VALOR_POUPANCA_MES)).sendKeys(geraValorRandomico(0, 19));
    }

    public void sairDoCampoAplicacao(){
        AcessoSiteRunner.getDriver().findElement(By.id(VALOR_APLICACAO)).sendKeys(Keys.TAB);
    }

    public void sairDoCampoValorAPoupar(){
        AcessoSiteRunner.getDriver().findElement(By.id(VALOR_POUPANCA_MES)).sendKeys(Keys.TAB);
    }

    public void validarMensagemDeValorInferiorAVinteReaisAplicacao(){
        Assert.assertEquals("Valor mínimo de 20.00", AcessoSiteRunner.getDriver().findElement(By.id(ERRO_VALOR_APLICACAO)).getText());
    }

    public void validarMensagemDeValorInferiorAVinteReaisPoupar(){
        Assert.assertEquals("Valor mínimo de 20.00", AcessoSiteRunner.getDriver().findElement(By.id(ERRO_VALOR_A_POUPAR)).getText());
    }

}
