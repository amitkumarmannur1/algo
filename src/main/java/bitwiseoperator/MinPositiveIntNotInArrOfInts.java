package bitwiseoperator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinPositiveIntNotInArrOfInts {
    public static int solution(int[] a) {
        int[] b = Arrays.stream(a).sorted().boxed().mapToInt(i -> i).toArray();
        int max = Arrays.stream(a).filter(i -> i > 1).max().orElse(1);
        int result = max;

        if (result > 1) {
            result = IntStream.range(1, result).filter(i -> Arrays.binarySearch(b, i) < 0).findFirst().orElseGet(() -> max + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        MinPositiveIntNotInArrOfInts minPositiveIntNotInArrOfInts=new MinPositiveIntNotInArrOfInts();
        System.out.println(MinPositiveIntNotInArrOfInts.solution(new int[]{8,9,6,4,4,7}));
    }



}
