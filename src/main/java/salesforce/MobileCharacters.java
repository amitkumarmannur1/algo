package salesforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MobileCharacters {
    static List<String> ans = new ArrayList<>();
    static List<String> ans2 = new ArrayList<>();
    static List<String> theAnswer = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(letterCombinations("234"));
        permutation("", "def");
        System.out.println(ans2);
        System.out.println(letterCombinations2("234"));



        // Function call
        letterCombinations3("234");

    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap<>();
        List<char[]> input = new ArrayList<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        for (int i = 0; i < digits.length(); i++) {
            input.add(map.get(digits.charAt(i)));
        }

        dfs(new ArrayList<Character>(), 0, input);
        return ans;
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            ans2.add(prefix);
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    private static void dfs(List<Character> cur, int start, List<char[]> input) {
        if (input.size() == 0) return;
        if (cur.size() == input.size()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : cur) {
                sb.append(c);
            }
            String newstr = sb.toString();
            ans.add(newstr);
            return;
        }
        //start每次dfs都在加一， 所以不用管外部循环， 只需要加一个针对每个char[]的内循环
        for (char c : input.get(start)) {
            cur.add(c);
            dfs(cur, start + 1, input);
            cur.remove(cur.size() - 1);
        }
    }

    public static List<String> letterCombinations2(String digits) {
        // Will contain the answer

        // A map of phone keys
        Map<Character, String> phone = new HashMap<>();
        // Adding the entries
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        // If "" return
        if (digits.isEmpty()) {
            return theAnswer;
        }
        // Call recursive method
        allLetterCombinations(digits, phone, "", digits.length());
        return theAnswer;
    }

    // Helper class for above to find all the possible chars per phone digits
    public static void allLetterCombinations(String digits, Map<Character, String> phone, String newStr, int size) {

        if (newStr.length() == size) {
            theAnswer.add(newStr);
        }

        for (int i = 0; i < digits.length(); i++) {
            String options = phone.get(digits.charAt(i));
            for (char theChars : options.toCharArray()) {
                allLetterCombinations(digits.substring(i + 1), phone, newStr + theChars, size);
            }
        }
    }

    // Function to return a vector that contains
    // all the generated letter combinations
    static ArrayList<String>  letterCombinationsUtil(String number, int n, String[] table)
    {
        // To store the generated letter combinations
        ArrayList<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.remove();

            // If complete word is generated
            // push it in the list
            if (s.length() == n)
                list.add(s);
            else {
                String val = table[ number.charAt(s.length()) - '0'];
                for (int i = 0; i < val.length(); i++)
                {
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }

    // Function that creates the mapping and
    // calls letterCombinationsUtil
    static void letterCombinations3(String number)
    {
        // table[i] stores all characters that
        // corresponds to ith digit in phone
        String[] table
                = { "0",   "1",   "abc",  "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };

        ArrayList<String> list = letterCombinationsUtil(number, number.length(), table);

        // Print the contents of the list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }



    List<String> letterCombinationPractice(String number, int n, String[] table){

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();


        return result;
    }



}
