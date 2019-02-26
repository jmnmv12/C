package Bloco1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class b1_3 {

    public static void main(String[] args) throws IOException {
        System.out.println("Word Search Solver");

        List<String> stream= null;
        try{
            Path path = Paths.get("numbers.txt");
            stream= Files.readAllLines(path);

        }catch (FileNotFoundException e){
            System.out.println("File Not Found, the file should be in the project folder");

        }
        System.out.println(stream);

        for (String element:stream
             ) {
            
        }


    }
}
