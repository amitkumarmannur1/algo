package practice;

import java.util.Stack;
/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.



Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
*/

public class UnixCommandStack {
    public String simplifyPath(String path) {
        //path="/../";
        String[] s = path.split("/");

        for (String ss : s) {
//System.out.println(""+ss);
        }

        Stack<String> q = new Stack<>();

        for (String ss : s) {
            if (ss.equals("")) continue;
            if (ss.equals("..") && !q.isEmpty()) {
                q.pop();
            } else if (ss.equals("..") && q.isEmpty()) {
                continue;
            } else if (ss.equals(".")) continue;
            else {
                q.push(ss);
            }


        }
        StringBuffer out = new StringBuffer("");
        System.out.println(q.size());
        if (q.size() == 0) {
            out.append("/");
        }
        for (String ssss : q) {

            out.append("/" + ssss);
        }


        return out.toString();
    }

}
