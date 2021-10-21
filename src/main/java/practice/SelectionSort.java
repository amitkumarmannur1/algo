package practice;

import static practice.BubbleSort.swap;

public class SelectionSort {
    public static void main(String[] ads) {
        int[] intArray = {2, 4, 1, -22, 35, 3, 60, 10, 20, 30, 1};


        for (int i = intArray.length - 1; i > 0; i--) {

            int high = 0;
            for (int j = 1; j <= i; j++) {
                if (intArray[j] > intArray[high]) {
                    high = j;
                }
            }
            swap(intArray, high, i);
        }

        for (int a : intArray) {
            System.out.println(a);
        }
    }
}
