package Reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataReader {
    String configurationPath = "C:\\projects\\ProjetoPoupancaSicredi\\src\\test\\java\\Configurations\\";
    String appPath = configurationPath + "Configuration.properties";
    Properties properties = new Properties();


    public String getConfigurationProperty(String property){

        try {
            properties.load(new FileInputStream(appPath));
            switch (property){
                case "APPICATION_VALUE":
                    return properties.getProperty("APPICATION_VALUE");

                case "SAVINGS_MONTH_VALUE":
                    return properties.getProperty("SAVINGS_MONTH_VALUE");

                case "SAVINGS_PERIOD":
                    return properties.getProperty("SAVINGS_PERIOD");

                case "SIMULATION_BUTTON":
                    return properties.getProperty("SIMULATION_BUTTON");

                case "SIMULATION_RESULT_BLOCK":
                    return properties.getProperty("SIMULATION_RESULT_BLOCK");

                case "SIMULATION_VALUE_RESULT_TOTAL_VALUE":
                    return properties.getProperty("SIMULATION_VALUE_RESULT_TOTAL_VALUE");

                case  "RETURN_SIMULATION_PAGE":
                    return properties.getProperty("RETURN_SIMULATION_PAGE");

                case "APPLICATION_ERROR_MESSAGE":
                    return properties.getProperty("APPLICATION_ERROR_MESSAGE");

                case "SAVINGS_ERROR_MESSAGE":
                    return properties.getProperty("SAVINGS_ERROR_MESSAGE");

                case  "ACESS_SITE":
                    return properties.getProperty("ACESS_SITE");

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        catch (IOException e) {
             return  e.getMessage();
        }

        return null;
    }


}
