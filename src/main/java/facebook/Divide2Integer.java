package facebook;

public class Divide2Integer {
    public static void main(String[] args) {

        Divide2Integer divide2Integer = new Divide2Integer();

        System.out.println(divide2Integer.divide(10, 10));
    }

    public int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;

        int dvd = Math.abs(dividend);
        int dvs = Math.abs(divisor);

        int result = 0;
        while (dvd - dvs >= 0) {
            // Reset the value
            int dvs1 = dvs;
            int mul = 1;
            // while (dvd >= (dvs1 << 1)) {
            // the above doesn't work
            while (dvd - (dvs1 << 1) >= 0) {
                dvs1 <<= 1;
                mul <<= 1;
            }
            dvd -= dvs1;
            result += mul;
        }

        return dividend>0 == divisor>0 ? result : - result;
    }
}

