package Runner;

import Component.SimuladorInvestimentosComponent;
import Reader.LeituraDados;
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

    LeituraDados dados = new LeituraDados();

    private static String geraValorRandomico(int min, int max) {

        DecimalFormat formato = new DecimalFormat("0.00");
        if (min >= max) {
            throw new IllegalArgumentException("valor máximo deve ser maior que o mínimo");
        }

        Random numeroRandomico = new Random();
        return formato.format(numeroRandomico.nextInt((max - min) + 1) + min);
    }

    public void inserirValorDeAplicacao() {

        AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaValorAplicacao())).sendKeys(geraValorRandomico(20, 100));

    }

    public void inserirValorAPoupar() {
        AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaValorPoupancaMes())).sendKeys(geraValorRandomico(20, 100));
    }

    public void inserirTempoDePoupanca() {
        AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaQuantidadeTempoPoupanca())).sendKeys(geraValorRandomico(1, 12));
    }

    public void clicarBotaoOK() {
        AcessoSiteRunner.getDriver().findElement(By.className(dados.pegaBotaoSimular())).click();
    }

    public void validarSimulacaoComSucesso() {
        AcessoSiteRunner.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.className(dados.pegaBlocoResultadoSimulacao())));
        Assert.assertNotNull(dados.pegaValorTotalResultadoSimulacao());
    }

    public void retornarPaginaSimulacao(){
        AcessoSiteRunner.getDriver().findElement(By.xpath(dados.pegaBotaoRetornarPaginaSimulacao())).click();
    }

    public void inserirValorInferiorAVinteReaisValorAplicacao(){
        AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaValorAplicacao())).sendKeys(geraValorRandomico(0, 19));
    }

    public void inserirValorInferiorAVinteReaisValorAPoupar(){
        AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaValorPoupancaMes())).sendKeys(geraValorRandomico(0, 19));
    }

    public void sairDoCampoAplicacao(){
        AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaValorAplicacao())).sendKeys(Keys.TAB);
    }

    public void sairDoCampoValorAPoupar(){
        AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaValorPoupancaMes())).sendKeys(Keys.TAB);
    }

    public void validarMensagemDeValorInferiorAVinteReaisAplicacao(){
        Assert.assertEquals("Valor mínimo de 20.00", AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaErroValorAplicacao())).getText());
    }

    public void validarMensagemDeValorInferiorAVinteReaisPoupar(){
        Assert.assertEquals("Valor mínimo de 20.00", AcessoSiteRunner.getDriver().findElement(By.id(dados.pegaErroValorPoupar())).getText());
    }

}
