package facebook;

public class validWordAbbreviation {

    public static void main(String[] args) {

        validWordAbbreviation validWordAbbreviation = new validWordAbbreviation();

        System.out.println(validWordAbbreviation.validWordAbbreviation1("hi", "1"));


    }


    public boolean validWordAbbreviation1(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }

            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }


    public boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length();
        int n = abbr.length();
        int i = 0;
        int num = 0;
        for (int j = 0; j < n; j++) {
            char c = abbr.charAt(j);
            if (c >= 'a' && c <= 'z') {
                i += num;
                if (i < m && word.charAt(i) == c) {
                    num = 0;
                } else {
                    return false;
                }
                i++;
            } else { // c is a digit
                if (num == 0 && c == '0')
                    return false; // leading zero is invalid
                num = num * 10 + (c - '0');
            }
        }
        if (i + num != m)
            return false;
        return true;
    }
}
