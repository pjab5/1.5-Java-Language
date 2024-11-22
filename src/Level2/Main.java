package Level2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Properties config = new Properties();
        String dir = "../../src/config.properties";
        try {
            config.load(new FileInputStream(dir));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        OrderDirectory.Exercise3(config.getProperty("directory"),config.getProperty("directory_txt")+ FileSystems.getDefault().getSeparator()+config.getProperty("name_txt"));
    }
}