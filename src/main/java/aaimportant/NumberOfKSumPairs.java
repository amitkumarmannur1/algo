package aaimportant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfKSumPairs {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3, 1, 5, 1, 1, 1, 1, 1, 2, 2, 3, 2, 2}, 1));
    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i : nums) {
            int diff = k - i;
            if (map.containsKey(diff) && map.get(diff) > 0) {
                count++;
                map.put(diff, map.get(diff) - 1);
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return count;
    }

}
