public class AddBinary {
    static String addBinary(String a, String b) {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Travers both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char) (s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
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









    }

    private static int BinaryToInt(int a, int decimal, int p) {
        while(a!=0)
        {
            decimal+=((a%10)*Math.pow(2,p));
            a=a/10;
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
