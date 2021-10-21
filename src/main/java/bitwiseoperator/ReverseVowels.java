package bitwiseoperator;

import java.util.Arrays;

public class ReverseVowels {

    //qqqquorrriettta

//    Given a string s, reverse only all the vowels in the string and return it.
//
//    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
//
//
//
//            Example 1:
//
//    Input: s = "hello"
//    Output: "holle"
//    Example 2:
//
//    Input: s = "leetcode"
//    Output: "leotcede"


    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        for (int l = 0, h = chars.length - 1; l < h; l++, h--) {
            if (vowels.indexOf(chars[l]) < 0) {
                h++;
                continue;
            }
            if (vowels.indexOf(chars[h]) < 0) {
                l--;
                continue;
            }
            chars[l] ^= chars[h];
            chars[h] ^= chars[l];
            chars[l] ^= chars[h];
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("qqqqaerrriotttuqqi"));

        System.out.println(reverseVowels.sortArray(new int[]{10,2,3,4,5,6}));

        System.out.println(reverseVowels.sortArray(new int[]{90,10,10, 11, 1, 90, 8,2, 7, 6, 4,1,20}, new int[] { 80,2,100}));
    }


    public String sortArray(int[] arr) {

        int count =0;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {

            System.out.println(count++);
            if (arr[i] > arr[j]) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                i--;
                j++;
                continue;
            }
            if (arr[i] <= arr[j]) {

                i--;

                if (i + 1 == j - 1) {

                    i++;
                    j = arr.length;
                }

            }

        }


        return Arrays.toString(arr);

    }

    public String sortArray(int[] arr,int[] arr1) {

        for (int i = 0, j = arr1.length - 1; i < j; i++, j--) {

            if (arr[i] > arr1[j]) {
                arr[i] ^= arr1[j];
                arr1[j] ^= arr[i];
                arr[i] ^= arr1[j];
                i--;
                j++;
                continue;
            }
            if (arr[i] <= arr1[j]) {

                i--;

                if (i + 1 == j - 1) {

                    i++;
                    j = arr1.length;
                }

            }

        }


        return Arrays.toString(arr);

    }

}
