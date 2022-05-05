package salesforce;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("phewwnphe"));
    }


    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int i = 0;
        int result = 0;
        int[] chars = new int[128]; // char tables by default accessible with O(1) for all ascii values from 0 - 128

        while(i < s.length()) {
            char r = s.charAt(i);

            int count = chars[r];
            if(count >= 1 && count >= left) {
                left = count;
            }

            result = Math.max(result, i - left + 1 );

            // assign the i value to char and increment i
            chars[r] = ++i;
        }

        return result;

    }
}
