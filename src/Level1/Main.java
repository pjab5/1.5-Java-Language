package Level1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dir = "..\\..\\src";
        System.out.println(OrderDirectory.Exercise1(dir));
        try {
            System.out.println("\nDirectory tree");
            OrderDirectory.Exercise2(dir,"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OrderDirectory.Exercise3(dir,dir+ FileSystems.getDefault().getSeparator()+"Ex1_directories.txt");
        OrderDirectory.Exercise4(dir+ FileSystems.getDefault().getSeparator()+"Ex1_directories.txt");
        OrderDirectory.Ex5_serialize(new Persona(27,"Pau"), dir+FileSystems.getDefault().getSeparator()+"directories.ser");
        System.out.println(OrderDirectory.Ex5_deserialize(dir+FileSystems.getDefault().getSeparator()+"directories.ser"));
    }
}