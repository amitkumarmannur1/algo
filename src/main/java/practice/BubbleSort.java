package practice;

public class BubbleSort {

    public static void main(String[] asd) {
        int[] intArray = {2, 4, 1, -22, 35, 3, 60, 10, 20, 30, 1};

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] > intArray[j]) {
                    swap(intArray, i, j);
                }
            }
        }

        for(int i: intArray) {
            System.out.println(i);
        }

    }

    protected static void swap(int[] intArray, int i, int j) {
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }
}
