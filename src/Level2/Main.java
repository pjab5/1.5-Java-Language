package Level2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties config = new Properties();
        try {
            config.load(new FileInputStream("src/config.properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        OrderDirectory.Exercise3(config.getProperty("directory"),config.getProperty("directory_txt")+ FileSystems.getDefault().getSeparator()+config.getProperty("name_txt"));
    }
}