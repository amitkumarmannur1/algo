package aaimportant;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0)
                count++;
        }
        if (count == nums.length) {
            return "0";
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String str = nums[i] + "" + nums[j];
                String str1 = nums[j] + "" + nums[i];
                if (str.compareTo(str1) < 1) {
                    int x = nums[j];
                    nums[j] = nums[i];
                    nums[i] = x;
                }
            }
        }
        StringBuilder str2 = new StringBuilder();
        for (int num : nums) {
            str2.append(num);
        }
        return str2.toString();

    }
}
