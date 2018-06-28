public class MinimumDistanceBetweenTwoPoints {

    static int minDist(int arr[], int n, int x, int y) {

        int min_dist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((x == arr[i] && y == arr[j] || y == arr[i] && x == arr[j]) && (min_dist > Math.abs(i - j)))
                    min_dist = Math.abs(i - j);
            }
        }
        return min_dist;
    }

    static int minDist2(int arr[], int n, int x, int y)
    {
        int i = 0;
        int min_dist = Integer.MAX_VALUE;
        int prev=0;

        // Find the first occurence of any of the two numbers (x or y)
        // and store the index of this occurence in prev
        for (i = 0; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                prev = i;
                break;
            }
        }

        // Traverse after the first occurence
        for (; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                // If the current element matches with any of the two then
                // check if current element and prev element are different
                // Also check if this value is smaller than minimum distance
                // so far
                if (arr[prev] != arr[i] && (i - prev) < min_dist)
                {
                    min_dist = i - prev;
                    prev = i;
                }
                else
                    prev = i;
            }
        }

        return min_dist;
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 5, 1, 2, 9, 0, 3, 9};
        System.out.println(minDist(arr, arr.length, 3, 2));
        System.out.println(minDist2(arr, arr.length, 3, 2));
    }
}
