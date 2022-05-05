package salesforce;
//You are given two strings a and b that consist of lowercase letters. In one operation, you can change any character in a or b to any lowercase letter.
//
//        Your goal is to satisfy one of the following three conditions:
//
//        Every letter in a is strictly less than every letter in b in the alphabet.
//        Every letter in b is strictly less than every letter in a in the alphabet.
//        Both a and b consist of only one distinct letter.
//        Return the minimum number of operations needed to achieve your goal.
//
//
//
//        Example 1:
//
//        Input: a = "aba", b = "caa"
//        Output: 2
//        Explanation: Consider the best way to make each condition true:
//        1) Change b to "ccc" in 2 operations, then every letter in a is less than every letter in b.
//        2) Change a to "bbb" and b to "aaa" in 3 operations, then every letter in b is less than every letter in a.
//        3) Change a to "aaa" and b to "aaa" in 2 operations, then a and b consist of one distinct letter.
//        The best way was done in 2 operations (either condition 1 or condition 3).
//        Example 2:
//
//        Input: a = "dabadd", b = "cda"
//        Output: 3
//        Explanation: The best way is to make condition 1 true by changing b to "eee".
public class MinCharSum {

    public static void main(String[] args) {
        //System.out.println(minCharacters("zzz","aaa"));
        System.out.println(minCharacters2("aba","caa"));
        //System.out.println(minCharacters3("","bbc"));
    }
    public static int minCharacters(String a, String b) {
        // strictly smaller or bigger means for each letter i, either all a smaller than i and b bigger than i, or b smaller than i and a bigger than i, if we record count for each letter in a, b we just need to add up the count bigger or smaller
        // for all a and b equal we just need to remove count of i

        int[] countsA = new int[26];
        int[] countsB = new int[26];

        for(int i = 0; i < a.length(); i++) countsA[a.charAt(i) - 'a']++;
        for(int i = 0; i < b.length(); i++) countsB[b.charAt(i) - 'a']++;

        int m = a.length();
        int n = b.length();
        int res = Integer.MAX_VALUE;
        int aSum = 0;
        int bSum = 0;

        for(int i = 0; i < 25; i++) {
            aSum += countsA[i];
            bSum += countsB[i];
            // make a >= i, b smaller than i
            int aBiggerOps = aSum + n - bSum;
            // make b >= i,
            int aSmallerOps = bSum + m - aSum;
            // all equal to i
            int equal = m + n - countsA[i] - countsB[i];

            res = Math.min(res, Math.min(aBiggerOps, Math.min(equal, aSmallerOps)));


        }

        return Math.min(res, m + n - countsA[25] - countsB[25]);
    }

    public static int minCharacters2(String a, String b) {
        int m = a.length(), n = b.length(), res = m + n;

        int[] c1 = new int[26], c2 = new int[26];
        for (int i = 0; i < m; ++i)
            c1[a.charAt(i) - 'a']++;
        for (int i = 0; i < n; ++i)
            c2[b.charAt(i) - 'a']++;

        for (int i = 0; i < 26; ++i) {
            res = Math.min(res, m + n - c1[i] - c2[i]);// condition 3
//            if (i > 0) {
//                c1[i] += c1[i - 1];
//                c2[i] += c2[i - 1];
//            }
//
//            if (i < 25) {
//                res = Math.min(res, m - c1[i] + c2[i]); // condition 1
//                res = Math.min(res, n - c2[i] + c1[i]); // condition 2
//            }
        }

        return res;
    }

    public static int minCharacters3(String A, String B) {
        int lenA = A.length(), lenB = B.length();
        int[] fmA = new int[26], fmB = new int[26];
        int best = 0, sumA = 0, sumB = 0;
        for (char c: A.toCharArray()) fmA[c - 'a']++;
        for (char c: B.toCharArray()) fmB[c - 'a']++;
        for (int i = 0; i < 26; i++)
            best = Math.max(best, fmA[i]+fmB[i]);
        for (int i = 0; i < 25; i++) {
            sumA += fmA[i];
            sumB += fmB[i];
            best = Math.max(best, Math.max(sumA-sumB+lenB, sumB-sumA+lenA));
        }
        return lenA + lenB - best;
    }
}

