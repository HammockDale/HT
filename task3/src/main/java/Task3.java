//https://docs.oracle.com/javaee/7/api/javax/json/stream/JsonParser.html
//import javax.json.stream.*;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Task3 {

    static void ft_eror(String s) {
        System.err.println(s);
        System.exit(1);
    }

        static JSONArray ft_values(JSONArray lang_1, Iterator i_1, HashMap<Object, Object> id_collect, JSONObject innerObj_1, JSONArray jsArray) {
//            System.out.println("STR = " + (innerObj_1.get("id")) + " " + id_collect.get(innerObj_1.get("id")));
//            if (id_collect.containsKey((innerObj_1.get("id")))) {
//                jsArray = ft_id(lang_1, i_1, id_collect, innerObj_1, jsArray);
//            }



            JSONArray jsArray_2 = new JSONArray();
            JSONArray lang_2 = (JSONArray) innerObj_1.get("values");
            Iterator i_2 = lang_1.iterator();
            if (i_2.hasNext()) {
//                if (id_collect.containsKey((innerObj_1.get("id")))) {
//                    jsArray = ft_id(lang_1, i_1, id_collect, innerObj_1, jsArray);
//                }
                i_2.next();
                jsArray_2 = (full_aray(lang_2, i_2, id_collect, jsArray_2));
//                innerObj_1.put("values", jsArray_2);

            }

        return jsArray;

    }
    static JSONArray ft_id(JSONArray lang_1, Iterator i_1, HashMap<Object, Object> id_collect, JSONObject innerObj_1, JSONArray jsArray ) {

//                System.out.println("STR = " + (innerObj_1.get("id")) + " " + id_collect.get(innerObj_1.get("id")));
//            jsArray.add(innerObj_1);



            innerObj_1.put("value", id_collect.get(innerObj_1.get("id")));
//            if (innerObj_1.get("values")) {
                JSONArray jsArray_2 = new JSONArray();
        JSONArray lang_2 = (JSONArray) innerObj_1.get("values");
        if (lang_2 != null) {
            Iterator i_2 = lang_2.iterator();
            while (i_2.hasNext()) {
                jsArray_2 = full_aray(lang_2, i_2, id_collect, jsArray_2);

//                JSONObject innerObj_2 = (JSONObject) i_2.next();
//            innerObj_2.put("values", jsArray_2);

//            JSONObject innerObj_2 = (JSONObject) i_2.next();
//            id_collect.put(innerObj_2.get("id"), innerObj_2.get("value"));
            }
            innerObj_1.put("values", jsArray_2);
        }


//            }
//            if (innerObj_1.containsKey((innerObj_1.get("values")))) {
//                System.out.println("HJK");
////                JSONArray jsArray_2 = new JSONArray();
//                jsArray_2 = full_aray(lang_1, i_1, id_collect, jsArray_2);
//                System.out.println(jsArray_2);
//                innerObj_1.put("values",  jsArray_2);
////                jsArray = ft_values(lang_1, i_1, id_collect, innerObj_1, jsArray);
//            }
        jsArray.add(innerObj_1);
        return jsArray;
    }



    static JSONArray full_aray(JSONArray lang_1, Iterator i_1, HashMap<Object, Object> id_collect, JSONArray jsArray ) {

        //        Iterator i_1 = lang_1.iterator();
        while (i_1.hasNext()) {
            JSONObject innerObj_1 = (JSONObject) i_1.next();

//            jsArray.add(innerObj_1);

//            else
//                jsArray.add(innerObj_1);
            if (id_collect.containsKey((innerObj_1.get("id")))) {
                jsArray = ft_id(lang_1, i_1, id_collect, innerObj_1, jsArray);
            }
//            if (id_collect.containsKey((innerObj_1.get("values")))) {
//                jsArray = ft_values(lang_1, i_1, id_collect, innerObj_1, jsArray);
//            }
//            if (id_collect.containsKey((innerObj_1.get("id")))) {
////                System.out.println("STR = " + (innerObj_1.get("id")) + " " + id_collect.get(innerObj_1.get("id")));
//                jsArray.add(innerObj_1);
//                innerObj_1.put("value", id_collect.get(innerObj_1.get("id")));
//
//            }
//            if (id_collect.containsKey((innerObj_1.get("values")))) {
//                JSONArray jsArray_2  = new JSONArray();
//                JSONArray lang_2 = (JSONArray) innerObj_1.get("values");
//                Iterator i_2 = lang_1.iterator();
//                if (i_2.hasNext()) {
//                    i_2.next();
////                        jsArray.add(full_aray(lang_2, i_2, id_collect, jsArray_2));
//                    innerObj_1.put("values", full_aray(lang_2, i_2, id_collect, jsArray_2));
//                    if (id_collect.containsKey((innerObj_1.get("id")))) {
//                        jsArray = ft_id(i_1, id_collect, innerObj_1, jsArray);
//                    }
//                }
////            } else {
////                jsArray.add(innerObj_1);
//            }
        }
        return jsArray;
    }

    static HashMap<Object, Object>  full_map(HashMap<Object, Object> id_collect,  FileReader reader_2 ) throws IOException, ParseException {
//        try {

            JSONParser jsonParser_2 = new JSONParser();
            JSONObject jsonObject_2 = (JSONObject) jsonParser_2.parse(reader_2);
//            JSONObject jsonObject_2 = new JSONObject();
                    JSONArray lang_2 = (JSONArray) jsonObject_2.get("values");
            Iterator i_2 = lang_2.iterator();

            while (i_2.hasNext()) {
                JSONObject innerObj_2 = (JSONObject) i_2.next();
                id_collect.put(innerObj_2.get("id"), innerObj_2.get("value"));
            }
        return id_collect;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            ft_eror("Wrong number of arguments");
        }

        String FILENAME = Task3.class.getResource(".").getPath() + "report.json";
//        System.out.println(FILENAME);
        JSONObject object_0 = new JSONObject();
//        object_0.put("report","");
        JSONArray jsArray = new JSONArray();
        HashMap<Object, Object> id_collect = new HashMap<>();



        try (FileWriter writer = new FileWriter(FILENAME)){
            // считывание файла JSON
            FileReader reader_1 = new FileReader(new File(args[0]));

            JSONParser jsonParser_1 = new JSONParser();
            JSONObject jsonObject_1 = (JSONObject) jsonParser_1.parse(reader_1);
//            JSONObject jsonObject_1 =  new JSONObject().getJSONObject();
//            JSONArray lang_1 = jsonObject_1.getJSONArray("test");
//            JSONArray lang_1= (JSONArray) jsonObject_1.getJSONObject("tests");

            // получение массива
            System.out.println(jsonObject_1);
            JSONArray lang_1=  (JSONArray)  jsonObject_1.get("tests");

            FileReader reader_2 = new FileReader(new File(args[1]));
            id_collect = full_map(id_collect, reader_2);
            //            берем элементы массива


            // берем каждое значение из массива json отдельно
            Iterator i_1 = lang_1.iterator();
            jsArray = full_aray(lang_1, i_1, id_collect, jsArray);

            object_0.put("report", jsArray);
            writer.write(object_0.toJSONString());
            writer.flush();
            writer.close();

//        } catch (ParseException | FileNotFoundException ex) {
//            ex.printStackTrace();
       } catch (IOException | ParseException e) {
           e.printStackTrace();
       }


    }
}
