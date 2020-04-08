package pramp;


import java.io.*;
import java.util.*;

public class FlattenDictionary {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {

        HashMap<String, String> resultMap = new HashMap<>();

        flattenDictHelper("", dict, resultMap);

        return resultMap;

    }

    private static void flattenDictHelper(String s, HashMap<String, Object> dict, HashMap<String, String> resultMap) {

        for(String key : dict.keySet()) {
            if(dict.get(key) instanceof HashMap) {
                if(s.length() == 0)
                    flattenDictHelper(key, (HashMap) dict.get(key), resultMap);
                else
                {
                        flattenDictHelper(s+"."+key, (HashMap) dict.get(key), resultMap);
                }
            }
            else {
                if(s.length() == 0)
                    resultMap.put(key, dict.get(key).toString());
                else if(key.length() != 0)
                    resultMap.put(s+"."+key, dict.get(key).toString());
            }
        }
    }

    public static void main(String[] args) {

        HashMap<String, Object> dictionary = new HashMap<>();
        dictionary.put("key1", 1);
        dictionary.put("key2", new HashMap<>());
        ((Map) dictionary.get("key2")).put("a", 2);
        ((Map) dictionary.get("key2")).put("b", 3);
        ((Map) dictionary.get("key2")).put("c", new LinkedHashMap<>());
        ((Map) ((Map) dictionary.get("key2")).get("c")).put("d", 3);
        ((Map) ((Map) dictionary.get("key2")).get("c")).put("", 1);

        HashMap<String, String> result  = flattenDictionary(dictionary);
        for(String key : result.keySet()) {
            System.out.println(key+" : " + result.get(key));
        }
    }

}
