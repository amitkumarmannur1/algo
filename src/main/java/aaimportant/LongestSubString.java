package aaimportant;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("amitaaiasdfghh"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        int longestLeft = 0;
        int longestRight = 0;
        int[] chars = new int[128];
        while(right < s.length()){
            char c = s.charAt(right);
            if(chars[c] > 0) {
                left = Math.max(left, chars[c]);
            }
            if(result < (right - left +1)){
                longestLeft = left;
                longestRight = right+1;
            }
            result = Math.max(result, right - left + 1);

            //System.out.println(s.substring(left,right));
            chars[c] = ++right;
        }
        System.out.println(s.substring(longestLeft,longestRight));
        return result;
    }
}
