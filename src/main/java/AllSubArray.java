import java.util.ArrayList;
import java.util.List;

public class AllSubArray {
    static int arr[] = new int[]{1, 2, 3};
    static char[] chars = "abc".toCharArray();

    static <T> void subArray(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<T> ts = new ArrayList<>();
                List<T> prefix = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    ts.add((T) new Integer(arr[k]));
                }
                permutation(prefix, ts);
                ts.clear();
                prefix.clear();
                /*for (int k = i; k <= j; k++) {
                    ts.add((T) new Character(chars[k]));
                }
                permutation(prefix, ts);
                ts.clear();
                prefix.clear();*/
            }

        }
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        System.out.println("All Non-empty Subarrays");
        subArray(arr.length);
    }

    private static <T> void permutation(List<T> prefix, List<T> str) {
        int n = str.size();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                List<T> strs = new ArrayList<>();
                List<T> pre = new ArrayList<>(prefix);
                pre.add(str.get(i));
                strs.addAll(str.subList(0, i));
                strs.addAll(str.subList(i + 1, n));
                permutation(pre, strs);
            }
        }
    }
}
