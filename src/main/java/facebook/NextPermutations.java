package facebook;

import java.util.Arrays;

public class NextPermutations {
    public static void main(String[] args) {

        NextPermutations nextPermutations = new NextPermutations();
        int[] nums =new int[]{1,2};
        nextPermutations.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void nextPermutation(int[] nums) {
        int size = nums.length;
        int i = size - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; --i) ;

        int j = i + 1;
        int k = size - 1;
        while (j < k) {
            //swap(nums[j],nums[k]);

            nums[j] ^= nums[k];
            nums[k] ^= nums[j];
            nums[j] ^= nums[k];
            ++j;
            --k;
        }


        if (i == -1)
            return;

        for (j = i + 1; j < size; ++j) {
            if (nums[j] > nums[i]) {
                // swap(nums[i],nums[j]);
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
                break;
            }
        }

    }
}
