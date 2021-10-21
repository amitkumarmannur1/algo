package practice;

public class QUickSortDelete {

    public static void main(String[] as) {

        int[] intArray = new int[]{5, 1, 3, 19, -1, 30, 2, -22};

        quickSort(intArray, 0, intArray.length);

        for (int i : intArray) {
            System.out.println(i);
        }

    }

    private static void quickSort(int[] intArray, int start, int end) {


        if (start < end) {
            int partition = partition(intArray, start, end);
            quickSort(intArray, start, partition);
            quickSort(intArray, partition + 1, end);
        }

    }

    private static int partition(int[] intArray, int start, int end) {

        int pivote = intArray[start];
        int i = start;
        int j = end;

        while (i < j) {

            while (i < j && intArray[--j] >= pivote) ;
            if (i < j) {
                intArray[i] = intArray[j];
            }
            while (i < j && intArray[++i] <= pivote) ;
            if (i < j) {
                intArray[j] = intArray[i];
            }
        }

        intArray[j] = pivote;
        return j;

    }
}
