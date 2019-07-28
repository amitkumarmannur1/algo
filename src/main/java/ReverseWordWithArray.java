import java.util.Optional;

public class ReverseWordWithArray {
    public static void main(String[] args) {
        System.out.println(reverseWrodWithArray("amitd"));
    }

    public static String reverseWrodWithArray(String s) {
        char c[] = s.toCharArray();
        int counter = 0;
        int l = c.length-1;
        while (counter < c.length / 2) {
            char c1 = c[counter];
            c[counter] = c[l];
            c[l] = c1;
            counter++;
            l--;
        }

        return String.valueOf(c);
    }
}
