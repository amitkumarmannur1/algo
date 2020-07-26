package practice;

import java.util.Arrays;

public class CountingArray {

    public static void main(String[] args) {
        int[] intArray = new int[]{2, 4, 1, 5, 1, 1, 10};

        count(intArray, 1, 10);

        for (int i : intArray) {
            System.out.println(i);
        }

    }

    private static void count(int[] intArray, int min, int max) {

        int[] countArray = new int[max + 1];

        for (int i = min; i < max; i++) {
            countArray[intArray[i]]++;
        }


        int j = 0;
        for (int i = min; j < max; j++) {
            while (countArray[i - min] > 0) {

                intArray[j++] = i;
                countArray[i - min]--;

            }
        }
    }


}
