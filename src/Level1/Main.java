package Level1;

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
            throw new RuntimeException(e);
        }
        System.out.println(OrderDirectory.Order("src"));
        OrderDirectory.OrderTree(config.getProperty("directory"),config.getProperty("directory_txt")+ FileSystems.getDefault().getSeparator()+config.getProperty("name_txt"));
        OrderDirectory.printTxt(config.getProperty("directory_txt")+ FileSystems.getDefault().getSeparator()+config.getProperty("name_txt"));
        OrderDirectory.serialize(new Persona(27,"Pau"), config.getProperty("directory")+FileSystems.getDefault().getSeparator()+"directories.ser");
        System.out.println(OrderDirectory.deserialize(config.getProperty("directory")+FileSystems.getDefault().getSeparator()+"directories.ser"));
    }
}