package Bloco1;

import com.sun.javafx.collections.MappingChange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class b1_6 {
    public static void main(String[] args) throws IOException {

        String file_path=args[0],final_output="";
        Scanner sc=new Scanner(System.in);

        List<String> stream= null,stream_out=null;
        Map<String,String> dic =new HashMap<>();
        try{
            Path path = Paths.get(file_path);
            stream= Files.readAllLines(path);

        }catch (FileNotFoundException e){
            System.out.println("File Not Found, the file should be in the project folder");

        }
        //System.out.println(stream);
        int index=0;
        for (String element:stream
        ) {

            String [] tokens=element.split("\\s+");
            dic.putIfAbsent(tokens[0].trim(),stream.get(index).replaceAll(tokens[0],"").trim());
            index++;
        }

        //System.out.println(dic);

        for(int j=1;j<args.length;j++){
            String target_file=args[j];
            try{
                Path path = Paths.get(target_file);
                stream_out= Files.readAllLines(path);

            }catch (FileNotFoundException e){
                System.out.println("File Not Found, the file should be in the project folder");

            }

            final_output+="\n"+stream_out.get(0)+"-->"+translate(stream_out,dic);

        }
        System.out.println(final_output.trim());
        /*while(sc.hasNext()){
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
        System.out.println(final_output);*/
    }

    public static String translate(List<String> b, Map<String,String> mapa){
        String final_output="";
        for (String a:b
             ) {
            String [] tokens=a.split("\\s+");

            for (String element_b:tokens
            ) {
                final_output+=connect_recurive(element_b,mapa).replaceAll("\\s+"," ");


            }

        }

        return final_output;
    }


    public static String connect_recurive(String a, Map<String,String> mapa){
        String final_output="",local_output="";
        if(mapa.containsKey(a.trim())){
            local_output+=mapa.get(a)+" ";
            String [] tokens=local_output.split("\\s+");
            for (String b:tokens
                 ) {
                final_output+=connect_recurive(b,mapa)+" ";
            }
            return final_output;
        }
        else
            return  a+" ";
    }
}

