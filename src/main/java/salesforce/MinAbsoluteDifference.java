package salesforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsoluteDifference {
     public List<List<Integer>> minimumAbsDifference(int[] arr) {
         List<List<Integer>> res = new ArrayList<>();

         Arrays.sort(arr);

         int minEle = Integer.MAX_VALUE;

         for(int i=0; i < arr.length - 1; i++) {
             int diff = arr[i+1] - arr[i];
             if(diff < minEle) {
                 minEle = diff;
                 res = new ArrayList<>();
                 res.add(Arrays.asList(arr[i],arr[i+1]));
             }else if(diff == minEle){
                 res.add(Arrays.asList(arr[i],arr[i+1]));
             }
         }

         return res;
     }
}
