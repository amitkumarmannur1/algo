package facebook;

import java.util.LinkedHashMap;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) { //Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (sb.length() != 0 && sb.charAt(sb.length()-1) == c  ){
                //st.pop();
                sb.replace(sb.length()-1,sb.length(),"");
            } else {
                //st.push(c);
                sb.append(c);
            }
        }



        return sb.toString();

    }
}
