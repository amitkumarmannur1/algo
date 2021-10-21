package facebook;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();

        System.out.println(simplifyPath.simplifyPath("/home/../a/./b/"));

    }

    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.equals(".."))
                st.pollFirst();
            else
                if (s.equals(".") || s.isEmpty())
                continue;
            else st.addFirst(s);
        }
        if (st.isEmpty()) return "/";
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append("/").append(st.pollLast());
        }
        return ans.toString();
    }
}
