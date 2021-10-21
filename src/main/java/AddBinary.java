public class AddBinary {
    static String addBinary(String a, String b) {

        // Initialize result
        int sum = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        String result = "";
        while (i >= 0 || j >= 0 || sum == 1) {

            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';

            result = (char) sum % 2 + result;

            sum = sum / 2;

            i--;
            j--;

        }

        return result;

    }


    public static String addIntegers(String a, String b) {

        String result = "";

        int i = a.length() - 1;
        int j = b.length() - 1;

        int sum = 0;

        while (i >= 0 || j >= 0 || sum ==1) {

            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';

            result = (char) sum % 10 + result;

            sum = sum / 10;

            i--;
            j--;

        }

        return result;
    }

    //Drive code
    public static void main(String args[]) {
        /*int a = 100, b = 100;
        int i = 8;
        StringBuilder x = intToBinary(i);
        System.out.println(x);
        //System.out.print(addBinary(a, b));
        int decimal=0,p=0,decimal1=0;

        decimal = BinaryToInt(a, decimal, p);
        decimal1 = BinaryToInt(b, decimal1, p);
        decimal=decimal+decimal1;
        x.delete(0,x.length());
        x=intToBinary(8);
        System.out.println(x);
        String a1 = "100", b1 = "100";
        System.out.println(addBinary(a1,b1));
        System.out.println(decimal);
*/

        intToBinary(10);


        System.out.println(addBinary("1010", "1011"));
        System.out.println(addIntegers("22", "29"));


    }

    private static int BinaryToInt(int a, int decimal, int p) {
        while (a != 0) {
            decimal += ((a % 10) * Math.pow(2, p));
            a = a / 10;
            p++;
        }
        return decimal;
    }

    private static String intToBinary(int input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input & 1);
        while ((input >>= 1) != 0) {
            sb.append(input & 1);
        }
        sb.append("b0");
        return sb.reverse().toString();
    }
}
