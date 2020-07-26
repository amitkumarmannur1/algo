package practice;
/* Iterative Java program for merge sort */

import java.lang.Math.*;


public class MergeSortIterative {


    /* Iterative mergesort function to sor
    t arr[0...n-1] */
    static void mergeSort(int[] arr, int n) {

        // For current size of subarrays to
        // be merged size varies from
        // 1 to n/2
        int size;

        // For picking starting index of
        // left subarray to be merged
        int start;


        // Merge subarrays in bottom up
        // manner. First merge subarrays
        // of size 1 to create sorted
        // subarrays of size 2, then merge
        // subarrays of size 2 to create
        // sorted subarrays of size 4, and
        // so on.
        for (size = 1; size < n; size = 2 * size) {

            // Pick starting point of different
            // subarrays of current size
            for (start = 0; start < n - 1; start += 2 * size) {
                // Find ending point of left
                // subarray. mid+1 is starting
                // point of right
                int mid = Math.min(start + size - 1, n - 1);

                int end = Math.min(start + 2 * size - 1, n - 1);

                // Merge Subarrays arr[start...mid]
                // & arr[mid+1...end]
                merge(arr, start, mid, end);
            }
        }
    }// {-15,20,35,-22,1,7,55}

    /* Function to merge the two haves arr[l..m] and
    arr[m+1..r] of array arr[] */
    static void merge(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        /* create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

		/* Copy data to temp arrays L[]
		and R[] */
        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

		/* Merge the temp arrays back into
		arr[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

		/* Copy the remaining elements of
		L[], if there are any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

		/* Copy the remaining elements of
		R[], if there are any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /* Function to print an array */
    static void printArray(int A[], int size) {
        int i;
        for (i = 0; i < size; i++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.printf("\n");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.printf("Given array is \n");
        printArray(arr, arr.length);

        mergeSort(arr, n);

        System.out.printf("\nSorted array is \n");
        printArray(arr, n);
    }

// This code is contributed by Smitha

}
