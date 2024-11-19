package Level1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println(OrderDirectory.Exercise1("src"));
        try {
            System.out.println("\nDirectory tree");
            OrderDirectory.Exercise2("src");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OrderDirectory.Exercise3("src","src"+ FileSystems.getDefault().getSeparator()+"Ex1_directories.txt");
        OrderDirectory.Exercise4("src"+ FileSystems.getDefault().getSeparator()+"Ex1_directories.txt");
        OrderDirectory.Ex5_serialize(new Persona(27,"Pau"), "src"+FileSystems.getDefault().getSeparator()+"directories.ser");
        System.out.println(OrderDirectory.Ex5_deserialize("src"+FileSystems.getDefault().getSeparator()+"directories.ser"));
    }
}