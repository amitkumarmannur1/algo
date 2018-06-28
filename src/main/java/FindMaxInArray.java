public class FindMaxInArray {

    static int findMax(int[] arr) {
        int max = arr[0];
        int second = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                second = arr[i];
            } else {
                second = max;
            }
            max = Math.max(arr[i], max);
        }
        System.out.println(second);
        System.out.println("The Maximum value is : " + max);
        return max;
    }


    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 7, 2, 9, 9, 2, 12};
        System.out.println(findMax(arr));

        int nums[]={1,1,2,4,1,3,1,1,9};
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProduct2(nums));
    }

    public static int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return max1 * max2 * max3;
    }
}
