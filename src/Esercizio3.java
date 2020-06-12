import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.Scanner;

public class Esercizio3 {

    private final static String DEFAULT_CONFIG_FILE = "conf.properties";

    public static void main(String[] args) {

        String configFileProperty = System.getProperties().getProperty("configFile", DEFAULT_CONFIG_FILE);

        try (Scanner scanner = new Scanner(System.in);) {

            File configFile = new File(configFileProperty);
            configFile.createNewFile();

            Properties properties = read(configFile);

            System.out.println("Il file " + configFile + " contiene " + properties.size() + " prop");

            while (true) {

                System.out.print("Vuoi aggiungere una proprietà? (y/n)");
                String answer = scanner.nextLine();

                if (!answer.matches("y"))
                    break;

                System.out.print("Chiave: ");
                String key = scanner.nextLine();
                System.out.print("Valore: ");
                String value = scanner.nextLine();
                properties.setProperty(key, value);
            }

            save(properties, configFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Properties read(File inputFile) {
        try (Reader reader = new FileReader(inputFile);) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void save(Properties properties, File outputFile) {
        try (Writer writer = new FileWriter(outputFile);) {
            System.out.println("Salvataggio...");
            properties.store(writer, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
