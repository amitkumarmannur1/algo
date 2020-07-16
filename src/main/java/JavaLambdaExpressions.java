
import java.io.IOException;


interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Write your code here
    public static PerformOperation isOdd() {
        return n -> ((n & 1) == 1);
    }

    public static PerformOperation isPrime() {
        return n -> {
            if (n < 2) {
                return false;
            } else {
                int k = (int) Math.sqrt(n);
                for (int i = 2; i <= k; i++) {
                    if (n % i == 0)
                        return false;
                }
                return true;
            }
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            String org = n + "";
            String newString = new StringBuffer(org).reverse().toString();
            return org.equals(newString);
        };
    }
}

public class JavaLambdaExpressions {
    public static void main(String[] args) throws IOException {
        PerformOperation op;
        boolean ret = false;
        String ans = null;

        int num=71;
        op = MyMath.isOdd();
        ret = MyMath.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
        System.out.println(ans);

        op = MyMath.isPrime();
        ret = MyMath.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
        System.out.println(ans);
        op = MyMath.isPalindrome();
        ret = MyMath.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
        System.out.println(ans);
    }
}