//https://docs.oracle.com/javaee/7/api/javax/json/stream/JsonParser.html
//import javax.json.stream.*;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;


import com.sun.javafx.collections.MappingChange;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


//private static final String FILENAME = Task3.class.getResource(".").getPath() + "src/main/resources/values.json";

public class Task3 {
    public static void main(String[] args) {
        String FILENAME = Task3.class.getResource(".").getPath() + "report.json";
        System.out.println(FILENAME);
        //Paths.get("./src/main/resources/values.json");

        JSONObject object_0 = new JSONObject();
        object_0.put("report","");
        JSONArray jsArray = new JSONArray();
        HashMap<Object, Object> id_collect = new HashMap<>();


        try (FileWriter writer = new FileWriter(FILENAME)){
            // считывание файла JSON
            FileReader reader_1 = new FileReader(new File(args[0]));

            JSONParser jsonParser_1 = new JSONParser();
            JSONObject jsonObject_1 = (JSONObject) jsonParser_1.parse(reader_1);

            System.out.println(jsonObject_1);
            FileReader reader_2 = new FileReader(new File(args[1]));

            JSONParser jsonParser_2 = new JSONParser();
            JSONObject jsonObject_2 = (JSONObject) jsonParser_2.parse(reader_2);
            System.out.println(jsonObject_2);


            // получение массива
            JSONArray lang_1= (JSONArray) jsonObject_1.get("tests");
            System.out.println("The first name is: " + lang_1);
            JSONArray lang_2= (JSONArray) jsonObject_2.get("values");
            System.out.println("The first name is: " + lang_2);



            Iterator i_2 = lang_2.iterator();

            while (i_2.hasNext()) {
                JSONObject innerObj_2 = (JSONObject) i_2.next();
                id_collect.put(innerObj_2.get("id") , innerObj_2.get("value"));
            }
            //            берем элементы массива

            Iterator i_1 = lang_1.iterator();

            // берем каждое значение из массива json отдельно
            while (i_1.hasNext()) {
                JSONObject innerObj_1 = (JSONObject) i_1.next();

                    if (id_collect.containsKey((innerObj_1.get("id")))) {
                        System.out.println("STR = " + (innerObj_1.get("id")) + " " + id_collect.get(innerObj_1.get("id")));
                        jsArray.add(innerObj_1);
                        innerObj_1.put("value", id_collect.get(innerObj_1.get("id")));
                    }
                    else {
                        jsArray.add(innerObj_1);
                    }
//
            }

//            берем элементы массива
//            for(int i=0; i<lang_2.size(); i++){
////                System.out.println("The " + i + " element of the array: "+lang_2.get(i));
//                jsArray.add(lang_2.get(i));
//            }

            object_0.put("report", jsArray);
            writer.write(object_0.toJSONString());
            writer.flush();
            writer.close();

        } catch (ParseException | FileNotFoundException ex) {
            ex.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }


    }
}
