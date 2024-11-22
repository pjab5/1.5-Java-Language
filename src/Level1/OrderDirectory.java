package Level1;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.Collator;
import java.util.*;

public class OrderDirectory {

    public static List<String> Exercise1(String directory){
        File dir = new File(directory);
        if(dir.list()!=null){
            List<String> directories = new ArrayList<>(List.of(dir.list()));
            directories.sort(Collator.getInstance());
            return directories;
        }
        return new ArrayList<>();
    }

    public static void Exercise2(String directory,String sep) throws IOException {
        System.out.println(sep+directory.substring(directory.lastIndexOf("\\")+1)+"(D)");
        for (String i :new ArrayList<>(List.of(Objects.requireNonNull(new File(directory).list())))){
            if(!i.contains(".")){
                Exercise2(directory + FileSystems.getDefault().getSeparator() + i,sep+"\t");
            }else{
                System.out.println(sep+"\t"+i + "(F) " + Files.readAttributes(Paths.get(directory + FileSystems.getDefault().getSeparator() + i) , BasicFileAttributes.class).lastModifiedTime());
            }
        }
    }

    public static void Exercise3(String directory, String file){
        try{
            FileWriter filewriter = new FileWriter(file);
            Exercise3_order(directory,filewriter,"");
            filewriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void Exercise3_order(String directory, FileWriter fileWriter, String sep) throws IOException {
        fileWriter.write(sep+directory.substring(directory.lastIndexOf("\\")+1)+"(D)\n");
        for (String i :new ArrayList<>(List.of(Objects.requireNonNull(new File(directory).list())))){
            if(!i.contains(".")){
                Exercise3_order(directory + FileSystems.getDefault().getSeparator() + i,fileWriter,sep+"\t");
            }else{
                fileWriter.write(sep+"\t"+i + "(F) " + Files.readAttributes(Paths.get(directory + FileSystems.getDefault().getSeparator() + i) , BasicFileAttributes.class).lastModifiedTime()+"\n");
            }
        }
    }

    public static void Exercise4(String path){
        System.out.println("\nFile contents:");
        try {
            for(String i:Files.readAllLines(Paths.get(path))){
                System.out.println(i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Ex5_serialize(Object object, String file){
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object Ex5_deserialize(String file) {
        Object object = new Object();
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return object;
    }
}
