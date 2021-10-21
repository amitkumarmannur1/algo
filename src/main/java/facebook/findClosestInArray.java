package facebook;

public class findClosestInArray {

    public static void main(String[] asd) {

        int[] arr = {1, 3, 4, 2, 5, 6, 10, 8, 12,6};

        System.out.println(findClosestInArray(arr, 7));
    }

    static int findClosestInArray(int[] arr, int x) {


        int result = arr[0];

        for (int value : arr) {

            result = Math.abs(result - x) < Math.abs(value - x) ? result : value;
        }

        return result;

    }
}
