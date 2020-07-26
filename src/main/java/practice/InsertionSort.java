package practice;

public class InsertionSort {

    public static void main(String[] asd) {
        int[] intArray = {4, 2, 1, -22, 35, 3, 60, 10, 20, 30, 1};

        insertionSort(intArray);

        for (int e : intArray) {
            System.out.println(e);
        }

    }

    private static void insertionSort(int[] intArray) {
        for (int i = 1; i < intArray.length; i++) {

            int j;
            int newElement = intArray[i];
            for (j = i; j > 0 && intArray[j - 1] > newElement; j--) {
                intArray[j] = intArray[j - 1];
            }
            intArray[j] = newElement;

        }
    }
}