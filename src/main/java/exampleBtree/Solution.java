package exampleBtree;

// find frequent occuring integer in an array
// eg: {1,2,3,3,3,2} ans: 3
//eg: {1,2,2,3,4,3} ans: 2 or 3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] ars) {


        Solution solution = new Solution();

        System.out.println(solution.getFrequentInt(new int[]{1, 1, 2, 3, 4}));
        System.out.println(solution.msgWrap("i am in seattle, its very wonderful place, this place is full of greenery", 11));
    }

    public int getFrequentInt(int[] arr) {

        int tempFrequent = arr[0];
        int count = 1;
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int i : arr) {
            if (frequent.containsKey(i)) {
                frequent.put(i, (int) frequent.get(i) + 1);
                int tempCount = (int) frequent.get(i) + 1;
                if (tempCount > count) {
                    count = tempCount;
                    tempFrequent = i;
                }

            } else {
                frequent.put(i, 1);
            }
        }

        return tempFrequent;
    }


    // "i am in seattle, its very wonderful place, this place is full of greenery"
    // 11 char
    //i am in
    //seattle,
    //its very
    // wonderful
    //place, this
    //place is
    //full of
    //greenery


    public List<String> msgWrap(String sentence, int sentenceLength) {
//        String[] s = sentence.split(" ");
////
////        String[] ss = new String[s.length];
////        StringBuffer stringBuffer = new StringBuffer();
////        List<String> strings = new ArrayList<>();
////        for (int i = 0; i < s.length; i++) {
////
////            if (stringBuffer.length() <= sentenceLength && stringBuffer.length() + s[i].length() + 1 < sentenceLength) {
////                stringBuffer.append(s[i] + " ");
////            } else {
////                i--;
////                strings.add(stringBuffer.toString() + " " + stringBuffer.length());
////                stringBuffer = new StringBuffer();
////            }
////        }
////        return strings;
////
////    }


        String[] ss = sentence.split(" ");
        List<String> msg = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ss.length; i++) {
            if (stringBuilder.length() + ss[i].length() + 1 <= sentenceLength)
                stringBuilder.append(ss[i] + " ");

            else if (stringBuilder.length() + ss[i].length() < sentenceLength) {
                stringBuilder.append(ss[i]);
            } else if (stringBuilder.length() + ss[i].length() > sentenceLength) {
                msg.add(stringBuilder.toString());
                if(i+1 >= ss.length){
                    i=0;
                    stringBuilder = new StringBuilder();
                }
            }

        }

        return msg;

    }

}

