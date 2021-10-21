public class findUnsortedSubarray {

    public static void main(String[] args) {
        findUnsortedSubarray findUnsortedSubarray = new findUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{1,5,2,3,4}));
    }

    public int findUnsortedSubarray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int begin = -1, end = -1;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);//from left to right, search the current max
            min = Math.min(min, nums[nums.length - 1 - i]); // from right to left, search the current min

            if (nums[i] < max)
                end = i;

            if (nums[nums.length - 1 - i] > min)
                begin = nums.length - 1 - i;
        }

        if (begin == -1)
            return 0;//already sorted

        return end - begin + 1;
    }
}
