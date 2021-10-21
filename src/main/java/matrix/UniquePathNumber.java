package matrix;

import java.util.Arrays;

public class UniquePathNumber {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 3));
    }

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
