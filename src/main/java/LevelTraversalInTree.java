import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LevelTraversalInTree {

    //a: b, c
    //b: a,c,d
    //c: a,d,g
    //d: e,f
    //e: f

    public static void main(String[] asd) {
        Map<String, Set<String>> frnds = new HashMap<>();

        Set<String> strings = new HashSet<>();
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");

        frnds.put("a",strings);
        Set<String> strin2 = new HashSet<>();
        strin2.add("e");
        strin2.add("c");
        strin2.add("i");
        frnds.put("b",strin2);
        Set<String> strin3 = new HashSet<>();
        strin3.add("f");
        strin3.add("g");
        strin3.add("h");
        frnds.put("c",strin3);

        new LevelTraversalInTree().listOfFrnds(frnds,"a");
    }



    Map<String, Set<String>> listOfFrnds(Map<String, Set<String>> frnds, String name) {

        Map<String, Set<String>> stringSetMap = new HashMap<>();
        stringSetMap.put("list of %d frnds" + 1, frnds.get(name));

        Set<String> last = new HashSet<>();
        int count = 0;
        last = frnds.get(name);
        do {
            Set<String> asd = new HashSet<>();

            for (String s : last) {

                if(frnds.get(s) != null)
                asd.addAll(frnds.get(s));

            }

            last = asd;
            stringSetMap.put("i am at %d" + count++, asd);
        } while (!last.isEmpty());


        return stringSetMap;
    }

}
