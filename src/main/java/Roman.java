import java.util.HashMap;
import java.util.Map;

public class Roman {

    Map<Character, Integer> map = new HashMap<Character, Integer>();

    public Roman() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int val1, val2;
        for (int i = 0; i < s.length(); i++) {
            val1 = map.get(s.charAt(i));
            if (i < s.length() - 1) {
                val2 = map.get(s.charAt(i + 1));
                if (val1 >= val2) {
                    sum += val1;
                } else {
                    sum += (val2 - val1);
                    i += 1;
                }
            } else {
                sum += val1;
            }
        }
        return sum;
    }

    public static void main(String[] asd) {
        Roman roman = new Roman();
        System.out.println(roman.romanToInt("LXXIX"));
        System.out.println(roman.intToRoman(3));
        System.out.println(roman.intToRoman2(3));
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(numerals[i]);
            }
        }

        return result.toString();
    }


    public String intToRoman2(int num) {
        String[] roman = {"I", "IV", "V", "IX", "X", "L", "C"};
        int[] value = {1, 4, 5, 9, 10, 50, 100};


        StringBuilder stringBuffer = new StringBuilder();
        while (num != 0) {
            for (int i = 0; i <= roman.length - 1; i++) {

                if (value[i] < num) {

                } else if (value[i] == num) {
                    num = num - value[i];
                    stringBuffer.append(roman[i]);
                    break;
                } else if (value[i] > num) {
                    num = num - value[i - 1];
                    stringBuffer.append(roman[i - 1]);
                    break;
                }
            }
        }

        return stringBuffer.toString();

    }

}
