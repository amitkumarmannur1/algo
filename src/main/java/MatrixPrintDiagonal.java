import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.k.mannur on 2/10/2018.
 */
public class MatrixPrintDiagonal {


    public static void main(String[] as) {
        int[][] a ={{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 1, 2, 3}};

        //printDiagonal(a);
        //printSideDiagonal(a);
        System.out.println(spiralOrder1(a));
        System.out.println(spiralOrder2(a));
        System.out.println(spiralOrder3(a));
        System.out.println(spiralOrder4(a));
    }
    public static List<Integer> spiralOrder4(int[][] arr) {
        List<Integer> list=new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        int left = 0;
        int right = m-1;
        int top = 0;
        int down = n-1;
        while(left<=right){

            //traversing right
            for(int i=left;i<=right;i++){
                list.add(arr[top][i]);
            }
            top++;
            if(left>right || top>down)break;

            //traversing down
            for(int i=top;i<=down;i++){
                list.add(arr[i][right]);
            }
            right--;
            if(left>right || top>down)break;

            //traversing left
            for(int i=right;i>=left;i--){
                list.add(arr[down][i]);
            }
            down--;
            if(left>right || top>down)break;

            //traversing up
            for(int i=down;i>=top;i--){
                list.add(arr[i][left]);
            }
            left++;
            if(left>right || top>down)break;
        }
        return list;
    }
    public static List<Integer> spiralOrder1(int[][] A) {
        List<Integer> res = new ArrayList<>();
        int m = A.length, n = A[0].length, up = 0, left = 0, right = n - 1, down = m - 1;
        for (; res.size() < m * n; left++, right--, up++, down--) {
            for (int j = left; j <= right; j++) res.add(A[up][j]);
            for (int i = up + 1; i <= down; i++) res.add(A[i][right]);
            if (up != down) for (int j = right - 1; j >= left; j--) res.add(A[down][j]);
            if (left != right) for (int i = down - 1; i > up; i--) res.add(A[i][left]);
        }
        return res;
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i=0,j=0,k=rows-1,l=cols-1;
        int m=0,n=0;
        while(result.size() < (rows * cols)){

            for(j=n;j <= l; j++){
                result.add(matrix[i][j]);
            }
            j--;
            m++;
            if(result.size() == (rows*cols)){
                break;
            }

            for(i=m;i <= k; i++){
                result.add(matrix[i][j]);
            }
            i--;
            l--;
            if(result.size() == (rows*cols)){
                break;
            }

            for(j=l; j >= n; j--){
                result.add(matrix[i][j]);
            }
            j++;
            k--;
            if(result.size() == (rows*cols)){
                break;
            }

            for(i=k; i>=m; i--){
                result.add(matrix[i][j]);
            }
            i++;
            n++;
            if(result.size() == (rows*cols)){
                break;
            }

        }
        return result;
    }

    public static List<Integer> spiralOrder3(int[][] mat) {
        int m = mat.length, n = mat[0].length, d = 0;
        int[] dir = {-1, 0, 1, 0, -1};
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int r = 0, c = 0; res.size() < m * n; ) {
            if (!visited[r][c]) {
                res.add(mat[r][c]);
                visited[r][c] = true;
            }

            int nr = r + dir[d], nc = c + dir[d + 1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc])
                d = d == 3 ? 0 : d + 1;
            else {r = nr; c = nc;}
        }

        return res;
    }

    private static void printSideDiagonal(int[][] a) {

        int m = a.length;
        int n=a[0].length;

        for(int k = 0; k<n;k++){
            int j = k;
            int i = 0;
            while(j>=0 && i<m){
                System.out.print(a[i][j]);
                i++;
                j--;
            }
            System.out.println();
        }

        for(int k = 1; k<m;k++){
            int j = n-1;
            int i=k;
            while(j>=0 && i <= m-1){
                System.out.print(a[i][j]);
                i++;
                j--;
            }
            System.out.println();
        }
    }

    private static void printDiagonal(int[][] a) {
        int m = a.length;
        int n = a[1].length;
        for (int k = 0; k < m; k++) {
            int i = k;
            int j = 0;
            while (i >= 0) {
                System.out.print(a[i][j]+" ");
                i--;
                j++;
            }
            System.out.println();
        }
        for (int k = 1; k < n; k++) {
            int i = m - 1;
            int j = k;
            while (j < n) {
                System.out.print(a[i][j]+" ");
                i--;
                j++;
            }
            System.out.println();
        }
    }
}
