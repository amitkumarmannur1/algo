import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 11/7/2017.
 */
public class LongestSubString {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // check if either rectangle is actually a line
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] ||
                rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            // the line cannot have positive overlap
            return false;
        }

        return rec1[2] > rec2[0] &&   // left
                rec2[1] < rec1[3] &&   // bottom
                rec1[0] < rec2[2] &&   // right
                rec1[1] < rec2[3];    // top
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0)
            return 0;

        if (s.length() < k)
            return s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = k;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - left);
                while (map.size() > k) {
                    char fc = s.charAt(left);
                    if (map.get(fc) == 1) {
                        map.remove(fc);
                    } else {
                        map.put(fc, map.get(fc) - 1);
                    }
                    left++;
                }
            }
        }

        maxLen = Math.max(maxLen, s.length() - left);
        System.out.println(s.substring(left, s.length()));
        return maxLen;
    }

    static void longestSubstring(String str) {
        int longestString = 0;
        Set as;
        Map<Character, Integer> characterMap = new LinkedHashMap<>();
        String as1 = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (characterMap.containsKey(str.charAt(i))) {
                i = characterMap.get(str.charAt(i));
                characterMap.clear();
            } else {
                characterMap.put(str.charAt(i), i);
            }
            if (characterMap.size() > longestString) {
                longestString = characterMap.size();
                as = characterMap.keySet();
                as1 = Arrays.stream(as.toArray())
                        .map(Object::toString)
                        .collect(Collectors.joining());

            }
        }
        System.out.println(as1);
        System.out.println(longestString);
    }

    public static void main(String as[]) {
        //System.out.println(longestSubString.lengthOfLongestSubstring("akomitaseada"));
        longestSubstring("pwwkew");
        System.out.println(LongestSubString.lengthOfLongestSubstringKDistinct("asdfg", 3));

    }
}

