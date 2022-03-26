package cisco;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class JsonTest {
    public static void main(String[] args) {
//        Response response = new Response();
//        response.version = "1";
//        List<String> list = new ArrayList<>();
//        list.add("35.1.1.220");
//        list.add("10.195.220.220");
//        list.add("192.192.192.220");
//        response.vips = list;
//
//
//        Vips vip = new Vips();
//        vip.version = "1.5.1";
//        vip.response = response;
//
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put( "response", response );
//        data.put( "version", "1.5.1" );


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("version", "1.5.1" );

        JSONObject item = new JSONObject();
        item.put("version", "1");
        JSONArray array = new JSONArray();
        array.add("35.1.1.220");
        array.add("10.195.220.220");
        item.put("vips", array);
        jsonObj.put("response", item);

        System.out.printf( "JSON: %s", jsonObj.toString() );
        System.out.println();


        JSONObject resp = (JSONObject) jsonObj.get("response");
        org.json.simple.JSONArray vips = (org.json.simple.JSONArray)
            resp.get("vips");
        for (int i = 0; i < vips.size(); i++) {
            String ip = (String)vips.get(i);
            System.out.println(ip);
        }
        System.out.println(vips.toString());

        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        System.out.println(list.toString());


        System.out.println(StringUtils.isEmpty(null));
    }
}
