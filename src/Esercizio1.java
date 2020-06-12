import java.util.Properties;

public class Esercizio1 {

    public static void main(String[] args) {
        
        Properties properties = System.getProperties();        
        System.out.println("System properties:");
        for (String key : properties.stringPropertyNames()) {
            System.out.println(" - " + key + " = " + properties.getProperty(key));
        }
    }
}
 