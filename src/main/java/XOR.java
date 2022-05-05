import java.util.HashSet;

/**
 * Created by amit.k.mannur on 4/12/2018.
 */

public class XOR {

//    public static void main(String[] args) {
//        int arr[]={1,2,1,2,3};
//        int j=0;
//        for(int i:arr){
//            j=j^i;
//            System.out.println(j);
//        }
//            System.out.println(j);
//    }




        // Function to find all possible values
// of Bitwise XOR such after rearranging
// the array elements the Bitwise XOR
// value at corresponding indexes is same
        static void findPossibleValues(int A[], int B[],
                                       int n)
        {
            // Stores the XOR of the array B[]
            int x = 0;

            for (int i = 0; i < n; i++) {
                x = x ^ B[i];
            }

            // Stores all possible value of
            // Bitwise XOR
            HashSet<Integer> numbers = new HashSet<Integer>();

            // Iterate over the range
            for (int i = 0; i < n; i++) {

                // Possible value of K
                int candidate = A[0] ^ B[i];
                int curr_xor = x;

                // Array B for the considered
                // value of K
                for (int j = 0; j < n; j++) {
                    int y = A[j] ^ candidate;
                    curr_xor = curr_xor ^ y;
                }

                // This means all the elements
                // are equal
                if (curr_xor == 0)
                    numbers.add(candidate);
            }

            // Print all the possible value
            for (int i : numbers) {
                System.out.print(i + " ");
            }
        }

        // Driver Code
        public static void main(String[] args)
        {
            int A[] = { 7, 8, 14 };
            int B[] = { 5, 12, 3 };
            int N = A.length;
            findPossibleValues(A, B, N);
        }

}
