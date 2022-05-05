package newLeetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//    You can return the answer in any order.
//
//
//
//            Example 1:
//
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//    Example 2:
//
//    Input: nums = [3,2,4], target = 6
//    Output: [1,2]
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,-14,14,-1,1, 2, 9, 7, 8, 12,14,15,16,17,18,19,122,54,12}, -13)));
        System.out.println(Arrays.toString(threeSum(new int[]{1, 2, 9, 7, 8, 12}, 22)));
        System.out.println(Arrays.toString(twoSumTry(new int[]{1,-14,14,-1,1, 2, 9, 7, 8, 12,14,15,16,17,18,19,122,54}, -13)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = i + 1;
        int spacer = 0;
        int count=0;
        while (i < nums.length && j < nums.length) {
            count++;
            if (nums[i] + nums[j] == target) {
                System.out.println("count look: "+count);
                return new int[]{nums[i], nums[j]};
                //return new int[]{i, j};
            }
            if (j == nums.length - 1) {
                spacer++;
                i = 0;
                j = i + 1 + spacer;
            }
            if (nums[i] + nums[j] == target) {
                System.out.println("count look: "+count);
                return new int[]{nums[i], nums[j]};
                //return new int[]{i, j};
            }
            i++;
            j++;
        }
        System.out.println("count look: "+count);
        return null;
    }


    public static int[] twoSumTry(int[] nums, int sum) {

        Map<Integer, Integer> map = new HashMap<>();
        //{1, 2, 9, 7, 8, 8}, 9))
        for(int i=0; i< nums.length; i++) {

            int diff = sum - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};


            map.put(nums[i], i);

        }
return null;
    }

    public static int[] threeSum(int[] nums, int target) {
        int i = 0;
        int j = i + 1;
        int k = i + 2;
        int spacer = 0;
        while (i < nums.length && j < nums.length && k < nums.length) {
            if (nums[i] + nums[j] + nums[k] == target) {
                return new int[]{nums[i], nums[j], nums[k]};
                //return new int[]{i, j};
            }
            if (k == nums.length - 1) {
                spacer++;
                i = 0;
                j = i + 1;
                k = i + 2 + spacer;

            }
            if (nums[i] + nums[j] + nums[k] == target) {
                return new int[]{nums[i], nums[j], nums[k]};
                //return new int[]{i, j};
            }
            i++;
            j++;
            k++;
        }
        return null;
    }
}
