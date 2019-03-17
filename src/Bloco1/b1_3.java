package Bloco1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class b1_3 {

    public static void main(String[] args) throws IOException {
        System.out.println("Word Search Solver");
        String file_path=args[0],to_find="",final_output="";
        Scanner sc=new Scanner(System.in);

        List<String> stream= null;
        Map<String,String> dic =new HashMap<>();
        try{
            Path path = Paths.get(file_path);
            stream= Files.readAllLines(path);

        }catch (FileNotFoundException e){
            System.out.println("File Not Found, the file should be in the project folder");

        }
        //System.out.println(stream);

        for (String element:stream
             ) {

            String [] tokens=element.split("-");
            dic.putIfAbsent(tokens[1].trim(),tokens[0]);
            
        }

        //System.out.println(dic);

        while(sc.hasNext()){
            to_find+=sc.next()+" ";

        }
        //System.out.println(to_find);
        String [] tokens_b=to_find.split("[\\s+ |-]");
        for (String element_b:tokens_b
             ) {
            System.out.println(element_b);
            if(dic.containsKey(element_b.trim())){
                final_output+=dic.get(element_b);
            }
            else
                final_output+=element_b+" ";

        }
        System.out.println(final_output);






    }
}
