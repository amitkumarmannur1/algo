package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    public static void main(String[] args) {
        GroupShiftedStrings groupShiftedStrings = new GroupShiftedStrings();

       // System.out.println(groupShiftedStrings.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
        System.out.println(groupShiftedStrings.groupStrings(new String[]{ "a", "z"}));
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String identifier = getIdentifier(s);
            if (!map.containsKey(identifier)) {
                map.put(identifier, new ArrayList<>());
            }
            map.get(identifier).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String getIdentifier(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            if (diff < 0)
                diff = 26 + diff;
            sb.append(diff);
            sb.append(":");
        }
        return sb.toString();
    }
}
