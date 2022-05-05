package salesforce;

public class SuperEGG {

    public static void main(String[] args) {
        System.out.println(superEggDrop(2,6));
    }
    public static int superEggDrop(int K, int N) {
        int low = 1, high = N;
        while (low < high) {
            int mid = (low + high) / 2;
            if (f(mid, K, N) < N)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static int f(int mid, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r *= mid-i+1;
            r /= i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }
}
