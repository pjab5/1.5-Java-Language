package Level2;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDirectory {

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

}
