package facebook;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("1*2"));

        System.out.println(calculator.calculateDqueue("1*2*3*4/6"));
        System.out.println(calculator.caclulatorPractice("1+10"));

    }

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }


    public int calculateDqueue(String s) {


        Deque<Integer> stack = new ArrayDeque<>();

        int num = 0;
        int sum = 0;
        char last_op = '+';

        s = s.trim();
        s = s.replace(" ", "");


        for (int i = 0; i < s.length(); i++) {


            if (Character.isDigit(s.charAt(i))) {

                //convert char to int and construct number
                num = num * 10 + (s.charAt(i) - '0');

            }

            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {

                if (last_op == '-') {

                    stack.add(-num);
                }
                if (last_op == '+') {

                    stack.add(num);
                }
                if (last_op == '*') {

                    int last_element = stack.pollLast();
                    stack.add(last_element * num);

                }
                if (last_op == '/') {

                    int last_element = stack.pollLast();
                    stack.add(last_element / num);
                }


                last_op = s.charAt(i);

                num = 0;
            }

        }


        for (Integer el : stack) {

            sum += el;

        }

        return sum;
    }


    public int caclulatorPractice(String s) {

        int result = 0;
        int number = 0;
        int lastNum = 0;
        int num = 0;
        char operator=' ';

        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }

            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {

                if (operator == '+' || operator == '-') {
                    result += lastNum;
                    lastNum = (operator == '+') ? num : -num;
                }

                if(operator == ' '){
                    lastNum = num;
                }
                operator = s.charAt(i);
                num = 0;


            }


        }

        result += lastNum;
        return result;


    }
}
