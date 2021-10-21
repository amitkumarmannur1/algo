package test;

import java.util.HashMap;
import java.util.Map;

public class Hugedata {


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();


        for(int i =0 ; i <50000000 ; i++){
            map.put(i,i);
        }
        for(int i =0 ; i <50000000 ; i++){
            map.get(i);
        }
    }


}
