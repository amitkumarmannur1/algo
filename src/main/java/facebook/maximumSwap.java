package facebook;


/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.



Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.
 */

public class maximumSwap {
    public static void main(String[] args) {
        maximumSwap maximumSwap = new maximumSwap();
        System.out.println(maximumSwap.maximumSwap(98368));

    }
    public int maximumSwap(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int max = i;
            for (int j = ch.length - 1; j > i; j--) {
                if (ch[j] > ch[max]) {
                    max = j;
                }
            }
            if (max > i) {
                ch[i] ^= ch[max];
                ch[max] ^= ch[i];
                ch[i] ^= ch[max];

                return Integer.valueOf(new String(ch));
            }
        }
        return num;
    }
}
