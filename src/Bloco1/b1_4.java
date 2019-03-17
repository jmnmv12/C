package Bloco1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class b1_4 {

    public static void main(String[] args) throws IOException {
        System.out.println("Word Search Solver");
        String file_path=args[0],to_find="",final_output="";
        Scanner sc=new Scanner(System.in);
        int num;
        double num1,local_multi=1,final_result=0;
        List<Integer> numbers=new ArrayList<>();
        Set<Double> set_multi=new HashSet<>();
        Set<Double> set_add=new HashSet<>();

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
            dic.putIfAbsent(tokens[1].trim(),tokens[0].trim());

        }

        //System.out.println(dic);

        while(sc.hasNext()){
            to_find+=sc.next()+" ";

        }
        //System.out.println(to_find);
        String [] tokens_b=to_find.split("[\\s+ |-]");
        for(int j=0;j<tokens_b.length;j++){
            if(dic.containsKey(tokens_b[j].trim())){
                num=Integer.parseInt(dic.get(tokens_b[j]));
                numbers.add(num);

            }

        }

        System.out.println(numbers);


        for(int j=0;j<numbers.size()-1;j++){
              double a=numbers.get(j),b=numbers.get(j+1);
              if(a<b){
                  set_multi.add(a);
                  set_multi.add(b);
              }
              else{
                  if(set_multi.isEmpty()){
                     local_multi+=a;
                     if(j==numbers.size()-2)
                         local_multi+=b;

                  }
                  for (Double element: set_multi
                       ) {
                       local_multi*=element;
                  }
                  final_result+=local_multi;
                  local_multi=1;
                  set_multi.clear();
                  
              }
              /*System.out.println(a+"+"+b);
              if(a>b){
                  set_add.add(a);
                  set_add.add(b);
              }
              else{
                  for (Double element: set_add
                       ) {                        
                       local_add+=element;
                  }
                  set_add.clear();


              }*/
        }
        System.out.println(final_result);
        //System.out.println(local_add);
   
   
   
   
   
   
   

   
   
   



         

    }

}
