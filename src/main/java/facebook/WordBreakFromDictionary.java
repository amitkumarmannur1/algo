package facebook;

import java.util.*;

public class WordBreakFromDictionary {

    public static void main(String[] args) {

        WordBreakFromDictionary wordBreakFromDictionary = new WordBreakFromDictionary();


        System.out.println(wordBreakFromDictionary.wordBreak("leetcodeleetamit",new ArrayList<String>(Arrays.asList("code","leet","et"))));

    }


    Set<String> visited = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        if(visited.contains(s)){
            return false;
        }

        for(String word: wordDict){
            if(word.equals(s)){
                return true;
            } else if(s.startsWith(word) && wordBreak(s.substring(word.length(), s.length()), wordDict)){
                return true;
            }
        }

        visited.add(s);
        return false;
    }
}
