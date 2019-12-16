package StepDefinitions;

import Component.AcessoSiteComponent;
import Component.SimuladorInvestimentosComponent;
import Runner.AcessoSiteRunner;
import Runner.SimuladorInvestimentosRunner;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class SimuladorInvestimentosStep {

    AcessoSiteComponent acessoSiteComponent = new AcessoSiteRunner();
    SimuladorInvestimentosComponent simuladorInvestimentosComponent = new SimuladorInvestimentosRunner();

    @Dado("Acesso o site de simulação de investimentos")
    public void acessoOSiteDeSimulacaoDeInvestimentos() {
        acessoSiteComponent.acessoSite();
    }

    @E("Insiro um valor de quanto de valor desejo aplicar")
    public void insiro_um_valor_de_quanto_de_valor_desejo_aplicar() {
        simuladorInvestimentosComponent.inserirValorDeAplicacao();
    }

    @E("Insiro o valor que desejo inserir todo o mês")
    public void insiro_o_valor_que_desejo_inserir_todo_o_mês() {
        simuladorInvestimentosComponent.inserirValorAPoupar();
    }

    @E("Insiro a quantidade de tempo que desejo poupar")
    public void insiro_a_quantidade_de_tempo_que_desejo_poupar() {
        simuladorInvestimentosComponent.inserirTempoDePoupanca();
    }

    @Quando("Clico em simular")
    public void clico_em_simular() {
        simuladorInvestimentosComponent.clicarBotaoOK();
    }

    @Então("É exibida os dados de simulação de investimento")
    public void e_exibida_os_dados_de_simulação_de_investimento(){
        simuladorInvestimentosComponent.validarSimulacaoComSucesso();
        simuladorInvestimentosComponent.retornarPaginaSimulacao();
    }

    @Dado("que insiro um valor inferior a vinte reais para valor de aplicação")
    public void que_insiro_um_valor_inferior_a_vinte_reais_para_valor_de_aplicacao() {
        simuladorInvestimentosComponent.inserirValorInferiorAVinteReaisValorAplicacao();
    }

    @Quando("saio do foco do campo valor de aplicação")
    public void saio_do_foco_do_campo_valor_de_aplicacao() {
        simuladorInvestimentosComponent.sairDoCampoAplicacao();
    }
    @Então("é exibida mensagem informando que deve ser inserido valor mínimo de valor de aplicacao é vinte reais")
    public void e_exibida_mensagem_informando_que_deve_ser_inserido_valor_minimo_de_valor_de_aplicacao_e_vinte_reais() {
        simuladorInvestimentosComponent.validarMensagemDeValorInferiorAVinteReaisAplicacao();
    }

    @Dado("que insiro um valor inferior a vinte reais para valor de poupança por mês")
    public void que_insiro_um_valor_inferior_a_vinte_reais_para_valor_de_poupanca_por_mes() {
        simuladorInvestimentosComponent.inserirValorInferiorAVinteReaisValorAPoupar();
    }

    @Quando("saio do foco do campo valor de a poupar")
    public void saio_do_foco_do_campo_valor_de_a_poupar() {
        simuladorInvestimentosComponent.sairDoCampoValorAPoupar();
    }

    @Então("é exibida mensagem informando que deve ser inserido valor mínimo de valor a poupar no mês é de vinte reais")
    public void e_exibida_mensagem_informando_que_deve_ser_inserido_valor_minimo_de_valor_a_poupar_no_mes_e_de_vinte_reais() {
        simuladorInvestimentosComponent.validarMensagemDeValorInferiorAVinteReaisPoupar();
        acessoSiteComponent.sairSite();
    }
}
