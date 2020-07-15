package hashmap;

import com.oracle.javafx.jmx.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("你", "1");
        hashMap.put("我", "1");
        hashMap.put("它", "1");
        for (String str :
                hashMap.keySet()) {
            int hashcode = str.hashCode();
            int index = hashcode % 3;
            System.out.println(String.format("key is %s,index is $d:", str, index));
        }


//        ArrayList arrayList = new ArrayList<String>(){};
//        System.out.println(arrayListst.getClass().getGenericSuperclass());
//
//        Map<String,String> map = new HashMap();
//        map.put("key","value");
//        String str = map.toString();
//        System.out.println("str " + str);
//        String value;
//        JSON
//        try {
//            JSONObject jsonObject = new JSONObject(str);
//            value = jsonObject.getString("key");
//            System.out.println("value:" + value);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }printStackTrace
    }
}
