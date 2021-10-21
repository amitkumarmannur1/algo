package facebook;

import java.util.HashSet;

public class checkContinousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = nums[0];
        HashSet<Integer> remainderSet = new HashSet<>();
        remainderSet.add(0);
        int preRem = nums[0] % k;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (remainderSet.contains(rem))
                return true;
            remainderSet.add(preRem);
            preRem = rem;
        }

        return false;
    }
}
