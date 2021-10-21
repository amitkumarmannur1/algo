package bitwiseoperator;

public class OddOccurrencesInArray {
    int solution(int[] A) {
        int result = 0;

        for (int a : A) {
            result ^= a;
        }

        return result;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

        System.out.println(oddOccurrencesInArray.solution(new int[]{1, 4 }));
    }
}
