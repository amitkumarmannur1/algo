package facebook;

public class AlienWords {
    public static void main(String[] asd){

        AlienWords alienWords = new AlienWords();
        String[] words = {"app","apple"};
        System.out.println(alienWords.isAlienSorted(words,"abcdefghijklmnopqrstuvwxyz"));

    }

    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length; i++) {
            String word1 = words[i];
            String word2 = "";
            if((i+1) <words.length)
                word2 = words[i+1];
            int j = 0;
            int k = 0;
            int m = word1.length();
            int n = word2.length();

            while(j < m && k < n) {
                char ch1 = word1.charAt(j), ch2 = word2.charAt(k);
                if(ch1 == ch2) {
                    ++j;
                    ++k;
                    if(m != n && j != m && k == n)
                        return false;
                    continue;
                }
                int i1 = order.indexOf(ch1);
                int i2 = order.indexOf(ch2);
                if(i1 < i2)
                    break;
                if(i1 > i2)
                    return false;
            }
        }

        return true;
    }
}
