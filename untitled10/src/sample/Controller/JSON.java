package sample.Controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class JSON {
    JSONObject obj = new JSONObject();

       /* obj.put("name", "mkyong.com");
        obj.put("age", new Integer(100));*/

    JSONArray list = new JSONArray();
       /* list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("f:\\test.json")) {

        file.write(obj.toJSONString());
        file.flush();

    } catch (IOException e) {
        e.printStackTrace();
    }*/



}
