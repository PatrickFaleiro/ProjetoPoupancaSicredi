package StepDefinitions;

import Component.AcessSiteComponent;
import Component.InvestimentSimulatorComponent;
import Runner.AcessSiteRunner;
import Runner.InvestimentSimulatorRunner;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class InvestimentSimulatorStep {

    AcessSiteComponent acessSiteComponent = new AcessSiteRunner();
    InvestimentSimulatorComponent investimentSimulatorComponent = new InvestimentSimulatorRunner();

    @Dado("Acesso o site de simulação de investimentos")
    public void acessoOSiteDeSimulacaoDeInvestimentos() {
        acessSiteComponent.acessSite();
    }

    @E("Insiro um valor de quanto de valor desejo aplicar")
    public void insiro_um_valor_de_quanto_de_valor_desejo_aplicar() {
        investimentSimulatorComponent.insertApplicationValue();
    }

    @E("Insiro o valor que desejo inserir todo o mês")
    public void insiro_o_valor_que_desejo_inserir_todo_o_mês() {
        investimentSimulatorComponent.insertSavingsValue();
    }

    @E("Insiro a quantidade de tempo que desejo poupar")
    public void insiro_a_quantidade_de_tempo_que_desejo_poupar() {
        investimentSimulatorComponent.insertSavingPeriod();
    }

    @Quando("Clico em simular")
    public void clico_em_simular() {
        investimentSimulatorComponent.clickButtonOk();
    }

    @Então("É exibida os dados de simulação de investimento")
    public void e_exibida_os_dados_de_simulação_de_investimento(){
        investimentSimulatorComponent.validateSucessSimulation();
        investimentSimulatorComponent.returnSimulationPage();
    }

    @Dado("que insiro um valor inferior a vinte reais para valor de aplicação")
    public void que_insiro_um_valor_inferior_a_vinte_reais_para_valor_de_aplicacao() {
        investimentSimulatorComponent.insertValueLowerThanTwentyReaisOnApplicationField();
    }

    @Quando("saio do foco do campo valor de aplicação")
    public void saio_do_foco_do_campo_valor_de_aplicacao() {
        investimentSimulatorComponent.exitApplicationField();
    }
    @Então("é exibida mensagem informando que deve ser inserido valor mínimo de valor de aplicacao é vinte reais")
    public void e_exibida_mensagem_informando_que_deve_ser_inserido_valor_minimo_de_valor_de_aplicacao_e_vinte_reais() {
        investimentSimulatorComponent.validateMessageApplicationFieldLowerThanTwentyReais();
    }

    @Dado("que insiro um valor inferior a vinte reais para valor de poupança por mês")
    public void que_insiro_um_valor_inferior_a_vinte_reais_para_valor_de_poupanca_por_mes() {
        investimentSimulatorComponent.insertValeuLowerThanTwentyReaisOnSavingsField();
    }

    @Quando("saio do foco do campo valor de a poupar")
    public void saio_do_foco_do_campo_valor_de_a_poupar() {
        investimentSimulatorComponent.exitSavingsField();
    }

    @Então("é exibida mensagem informando que deve ser inserido valor mínimo de valor a poupar no mês é de vinte reais")
    public void e_exibida_mensagem_informando_que_deve_ser_inserido_valor_minimo_de_valor_a_poupar_no_mes_e_de_vinte_reais() {
        investimentSimulatorComponent.validateMessageSavingsFieldLowerThanTwentyReais();
        acessSiteComponent.exitSite();
    }
}
