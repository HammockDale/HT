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

    static JSONArray ft_id(HashMap<Object, Object> id_collect, JSONObject innerObj_1, JSONArray jsArray ) {
        if ( id_collect.get(innerObj_1.get("id")) != null){
                innerObj_1.put("value", id_collect.get(innerObj_1.get("id")));
            }
                JSONArray jsArray_2 = new JSONArray();
        JSONArray lang_2 = (JSONArray) innerObj_1.get("values");
        if (lang_2 != null) {
            Iterator i_2 = lang_2.iterator();
            if (i_2.hasNext()) {
                jsArray_2 = full_aray(lang_2, i_2, id_collect, jsArray_2);
                innerObj_1.put("values", jsArray_2);
            }
        }
        jsArray.add(innerObj_1);
        return jsArray;
    }



    static JSONArray full_aray(JSONArray lang_1, Iterator i_1, HashMap<Object, Object> id_collect, JSONArray jsArray ) {
        while (i_1.hasNext()) {
            JSONObject innerObj_1 = (JSONObject) i_1.next();
                jsArray = ft_id(id_collect, innerObj_1, jsArray);
        }
        return jsArray;
    }

    static HashMap<Object, Object>  full_map(HashMap<Object, Object> id_collect,  FileReader reader_2 ) throws IOException, ParseException {
            JSONParser jsonParser_2 = new JSONParser();
            JSONObject jsonObject_2 = (JSONObject) jsonParser_2.parse(reader_2);
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
        JSONObject object_0 = new JSONObject();
        JSONArray jsArray = new JSONArray();
        HashMap<Object, Object> id_collect = new HashMap<>();
        try (FileWriter writer = new FileWriter(FILENAME)){
            FileReader reader_1 = new FileReader(new File(args[0]));
            JSONParser jsonParser_1 = new JSONParser();
            JSONObject jsonObject_1 = (JSONObject) jsonParser_1.parse(reader_1);
            System.out.println(jsonObject_1);
            JSONArray lang_1 =  (JSONArray)  jsonObject_1.get("tests");
            FileReader reader_2 = new FileReader(new File(args[1]));
            id_collect = full_map(id_collect, reader_2);
            Iterator i_1 = lang_1.iterator();
            jsArray = full_aray(lang_1, i_1, id_collect, jsArray);

            object_0.put("report", jsArray);
            writer.write(object_0.toJSONString());
            writer.flush();
            writer.close();
       } catch (IOException | ParseException e) {
           e.printStackTrace();
       }
    }
}
