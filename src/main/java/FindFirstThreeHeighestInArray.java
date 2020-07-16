public class FindFirstThreeHeighestInArray {

    public static void main(String[] as) {
        int arr[] = {12, 13, 1, 10, 34, 1};
        int n = arr.length;
        print3Largest(arr, n);

    }

    static void print3Largest(int arr[], int arr_size) {

        int i, first, second, third;

        /* There should be atleast two elements */
        if (arr_size < 3) {
            System.out.print(" Invalid Input ");
            return;
        }

        third = first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size; i++) {
            /* If current element is smaller than
            first*/
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
            second then update second  */
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third)
                third = arr[i];
        }

        System.out.println("Three largest elements are " +
                first + " " + second + " " + third);
    }


}
