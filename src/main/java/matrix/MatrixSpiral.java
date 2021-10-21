package matrix;

import java.util.ArrayList;
import java.util.List;


public class MatrixSpiral {

    //traverse matrix rows & column

    public static void main(String[] args) {
        int[][] mat
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {7, 8, 9}};


        System.out.println("------------------------");
        System.out.println(spiralOrder(mat));


    }

    private static List spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int L = 0, R = matrix[0].length;
        int T = 0, B = matrix.length;
        while (L < R && T < B) {
            for (int i = L; i <= R - 1; i++) {
                ans.add(matrix[T][i]);
            }
            T++;
            for (int i = T; i <= B - 1; i++) {
                ans.add(matrix[i][R - 1]);
            }
            R--;
            if (L < R && T < B) {
                for (int i = R - 1; i > L - 1; i--) {
                    ans.add(matrix[B - 1][i]);
                }
                B--;
                for (int i = B - 1; i > T - 1; i--) {
                    ans.add(matrix[i][L]);
                }
                L++;
            }

        }
        return ans;


//            j
//        i   01    02  03  04
//            11    12  13  14
//            21    22  23  24
//            31    32  33  34
//
//
//
//

    }
}
