import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    public static void main(String[] as){
        String[] strs={"cat","dog","act","asd","odg","dsa"};
        Anagram anagram=new Anagram();
        System.out.printf(String.valueOf(anagram.groupAnagrams(strs)));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            str=str.toLowerCase();
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i) - 'a'] += 1;
            }
            String ns = new String(arr);

            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}
