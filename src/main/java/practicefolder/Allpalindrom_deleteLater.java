package practicefolder;

public class Allpalindrom_deleteLater {

    public static void main(String[] args) {
        String str = "aabbaaa";
        allPalindromOfString(str);

        int arr[] = {1, 3, 55, -45, 100, -20, -10};
        findMaxSum(arr);
    }

    private static void findMaxSum(int[] arr) {
        int max = arr[0];
        int sum = 0;
        for (int a : arr) {
            sum = Math.max(sum+a,a);
            max=Math.max(sum,max);

        }
        System.out.println(max);
    }

    public static void allPalindromOfString(String str) {
        String longgestString = "";
        for (int i = 0; i < str.length(); i++)
            for (int j = i; j < str.length() - 1; j++) {

                if (checkPalindrom(str.substring(i, j + 1))) {
                    if (str.substring(i, j + 1).length() > longgestString.length()) {
                        longgestString = str.substring(i, j + 1);
                    }
                }
            }
        System.out.println(longgestString);
    }

    private static boolean checkPalindrom(String substring) {
        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i))
                return false;
        }
        return true;
    }
}
