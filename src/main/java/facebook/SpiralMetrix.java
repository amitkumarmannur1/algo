package facebook;

import java.util.ArrayList;
import java.util.List;

public class SpiralMetrix {


    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        SpiralMetrix spiralMetrix = new SpiralMetrix();
        System.out.println(spiralMetrix.spiralMetrics(m));
    }

    List<Integer> spiralMetrics(int[][] m) {

        int L = 0;
        int R = m[0].length;

        int T = 0;
        int B = m.length;

        List<Integer> result = new ArrayList<>();

        while (L < R && T < B) {

            // you go from left to right  and top remain constant only i changes
            //left to right at top
            for (int i = L; i < R; i++) {
                result.add(m[T][i]);
            }
            T++;

            // done with top , now need to go from top to bottom .
            // right  remains constant
            // top to bottom at right
            for (int i = T; i < B; i++) {
                result.add(m[i][R - 1]);
            }
            R--;

            if (L < R && T < B) {

                // go from right to left bottom
                //left to right at bottom
                for (int i = R - 1; i > L - 1; i--) {
                    result.add(m[B - 1][i]);
                }
                B--;

                // go from bottom to top at left.
                // go to top from bottom at left side.
                for (int i = B - 1; i > T - 1; i--) {

                    result.add(m[i][L]);
                }
                L++;
            }

        }


        return result;
    }


}
