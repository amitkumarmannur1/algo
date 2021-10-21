package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTraverse {

    //traverse matrix rows & column

    public static void main(String[] args) {
        int[][] mat
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {7, 8, 9}};

        //display row
        displayRowColumn(mat);
        System.out.println("--------display diagonal----------");
        //display diagonal
        displayRDiagonal(mat);


        System.out.println("------------------------");

        //display diagonal left to rgiht
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));

        System.out.println("------------------------");


    }

    private static void displayRowColumn(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.println(mat[i][j]);
            }
        }
    }

    private static void displayRDiagonal(int[][] mat) {
        System.out.println("-------left to right-----------");

        for (int i = 0; i < mat.length; i++) {
            if (i < mat[0].length) {
                System.out.println(mat[i][i]);
            }
        }
        System.out.println("--------Right to Left----------");
        for (int i = 0; i < mat[0].length; ) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                System.out.println(mat[i][j]);
                i++;
            }

        }
    }

//     = {{1, 2, 3},
//        {4, 5, 6},
//        {7, 8, 9}};

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int M = matrix.length, N = matrix[0].length;

        int[] result = new int[M * N];
        result[0] = matrix[0][0];
        //Initialization start position
        int i = 0, j = 0, k = 1;
        while (k < N * M) {
            //move up-right first
            while (i >= 1 && j < N - 1) {
                i--;
                j++;
                result[k++] = matrix[i][j];

            }
            //when we can't move up-right ,then move right one step
            if (j < N - 1) {
                j++;
                result[k++] = matrix[i][j];
            }
            //if we can't move right,just move down one step
            else if (i < M - 1) {
                i++;
                result[k++] = matrix[i][j];
            }
            //After that,we will move down-left until it can't move
            while (i < M - 1 && j >= 1) {
                i++;
                j--;
                result[k++] = matrix[i][j];
            }
            //if we can't move down-left,then move down
            if (i < M - 1) {
                i++;
                result[k++] = matrix[i][j];
            }
            //if we can't move down,just move right
            else if (j < N - 1) {
                j++;
                result[k++] = matrix[i][j];
            }

        }

        return result;
    }

}
