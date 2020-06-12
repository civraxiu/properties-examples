import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Esercizio2 {

    public static void main(String[] args) {
        
        String configFileProperty = System.getProperties().getProperty("configFile", "config.txt");
        
        File configFile = new File(configFileProperty);
        
        System.out.println("config file: " + configFile);
        
            
        Properties properties = new Properties();
        
        try {
            Reader reader = new FileReader(configFile);
            properties.load(reader);
            
            for (String key : properties.stringPropertyNames()) {
                System.out.println(" - " + key + " = " + properties.getProperty(key));
            }
            
            System.out.println();
            properties.list(System.out);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
} 
