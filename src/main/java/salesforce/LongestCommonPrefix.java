package salesforce;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.printf(longestCommonPrefix(new String[]{"leetcode","leetbite","lee"}));
    }



    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
