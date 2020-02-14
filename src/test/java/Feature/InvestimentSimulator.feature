
# language: pt
Funcionalidade: : Testes do simulador de investimento

  Cenario: Inserção de valores válidos para simulação
    Dado Acesso o site de simulação de investimentos
    E Insiro um valor de quanto de valor desejo aplicar
    E Insiro o valor que desejo inserir todo o mês
    E Insiro a quantidade de tempo que desejo poupar
    Quando Clico em simular
    Então É exibida os dados de simulação de investimento

  Cenario: Inserção de valor inferior a 20 reais no valor de aplicação
    Dado que insiro um valor inferior a vinte reais para valor de aplicação
    Quando saio do foco do campo valor de aplicação
    Então é exibida mensagem informando que deve ser inserido valor mínimo de valor de aplicacao é vinte reais

  Cenario: Inserção de valor inferior a 20 reais na quantidade de valor poupado por mês
    Dado que insiro um valor inferior a vinte reais para valor de poupança por mês
    Quando saio do foco do campo valor de a poupar
    Então é exibida mensagem informando que deve ser inserido valor mínimo de valor a poupar no mês é de vinte reais

