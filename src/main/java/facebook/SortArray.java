package facebook;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] asd) {

        System.out.println(sortArray(new int[]{1, 2, 3, 4, 5, 6, 1}));
        System.out.println(sortArrayKthlargest(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    public static String sortArray(int[] arr) {

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {

            if (arr[i] < arr[j]) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                i--;
                j++;
                continue;
            }
            if (arr[i] >= arr[j]) {

                i--;

                if (i + 1 == j - 1) {

                    i++;
                    j = arr.length;
                }

            }

        }
        return Arrays.toString(arr);
    }

    public static int sortArrayKthlargest(int[] arr, int k) {

        int index = 0;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {


            if (arr[i] < arr[j]) {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                i--;
                j++;
                //k--;

                continue;
            }
            if (arr[i] >= arr[j]) {

                i--;

                if (i + 1 == j - 1) {

                    if (k < i) {
                        return arr[k];
                    }
                    if (k > i) {
                        return arr[k - i];
                    }

                    i++;
                    j = arr.length;

                }

            }


        }
        return arr[index];
    }
}
