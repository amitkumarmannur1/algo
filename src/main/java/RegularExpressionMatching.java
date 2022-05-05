
//
//Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//
//        '.' Matches any single character.​​​​
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).
//
//
//
//        Example 1:
//
//        Input: s = "aa", p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".
enum Result {
    TRUE, FALSE
}

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aaab","ac*b"));

    }
    static Result[][] memo;

    public static boolean isMatch(String text, String pattern) {

        memo = new Result[text.length() + 1][pattern.length() + 1];

        return isMatch(0, 0, text, pattern);
    }

    public static boolean isMatch(int i, int j, String text, String pattern) {

        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }

        boolean ans;

        if (j == pattern.length() && i == text.length()) {
            return true;
        }else if (j == pattern.length() && i < text.length()) {
            return false;
        }else {
            boolean firstMatch = (i < text.length()
                    && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (isMatch(i, j + 2, text, pattern) || firstMatch && isMatch(i + 1, j, text, pattern));
            } else {
                ans = firstMatch && isMatch(i + 1, j + 1, text, pattern);
            }
        }

        memo[i][j] = ans ? Result.TRUE : Result.FALSE;

        return ans;
    }
}
