package Level1;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class OrderDirectory {

    public static List<String> Order(String directory){
        return new ArrayList<>(List.of(Objects.requireNonNull(new File(directory).list())));
    }

    public static void OrderTree(String directory, String file){
        try{
            FileWriter filewriter = new FileWriter(file);
            OrderTreeRec(directory,filewriter);
            filewriter.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void OrderTreeRec(String directory, FileWriter fileWriter) throws IOException {
        fileWriter.write(directory+"(D)\n");
        //System.out.println(directory+"(D)");
        for (String i :new ArrayList<>(List.of(Objects.requireNonNull(new File(directory).list())))){
            if(!i.contains(".")){
                OrderTreeRec(directory + FileSystems.getDefault().getSeparator() + i,fileWriter);
            }else{
                fileWriter.write(i + "(F) " + Files.readAttributes(Paths.get(directory + FileSystems.getDefault().getSeparator() + i) , BasicFileAttributes.class).lastModifiedTime()+"\n");
                //System.out.println(i + "(F) " + Files.readAttributes(Paths.get(directory + FileSystems.getDefault().getSeparator() + i) , BasicFileAttributes.class).lastModifiedTime());
            }
        }
    }

    public static void printTxt(String path){
        try {
            for(String i:Files.readAllLines(Paths.get(path))){
                System.out.println(i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void serialize(Object object, String file){
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Object deserialize(String file) {
        Object object = new Object();
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
