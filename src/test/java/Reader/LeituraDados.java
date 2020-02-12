package Reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeituraDados {
    String caminho = "C:\\projects\\ProjetoPoupancaSicredi\\src\\test\\java\\Configurations\\";
    String caminhoConfiguracao = caminho + "Configuracoes.properties";
    Properties properties = new Properties();


    public String pegaValorAplicacao() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("VALOR_APLICACAO");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaValorPoupancaMes() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("VALOR_POUPANCA_MES");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaQuantidadeTempoPoupanca() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("QUANTIDADE_TEMPO_POUCANCA");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaBotaoSimular() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("BOTAO_SIMULAR");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaBlocoResultadoSimulacao() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("BLOCO_RESULTADO_SIMULACAO");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaValorTotalResultadoSimulacao() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("VALOR_TOTAL_RESULTADO_SIMULACAO");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaBotaoRetornarPaginaSimulacao() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("BOTAO_RETORNAR_PAGINA_SIMULACAO");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaErroValorAplicacao() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("ERRO_VALOR_APLICACAO");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaErroValorPoupar() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("ERRO_VALOR_A_POUPAR");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String pegaAcessoPagina() {
        try {
            properties.load(new FileInputStream(caminhoConfiguracao));
            return properties.getProperty("ACESSO_PAGINA");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


}
