import java.util.*;

/**
 * Created by amit.k.mannur on 4/10/2018.
 */

public class LRUWithLinkedHashMap{

    public static void main(String args[]){

        LinkedHashMap<String,String> lhm = new LinkedHashMap<String,String>(4,0.75f,true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry<String,String> eldest) {
                return size() > 4;
            }
        };

        Map<String,String> stringStringMap=Collections.synchronizedMap(lhm);
        stringStringMap.put("test", "test");
        stringStringMap.put("test1", "test1");
        stringStringMap.put("1", "abc");
        stringStringMap.put("test2", "test2");
        stringStringMap.put("1", "abc");
        stringStringMap.put("test3", "test3");
        stringStringMap.put("test4", "test4");
        stringStringMap.put("test3", "test3");
        stringStringMap.put("1", "abc");
        stringStringMap.put("test1", "test1");


        System.out.println(lhm);
    }
}
