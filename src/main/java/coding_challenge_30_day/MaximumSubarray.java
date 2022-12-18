package coding_challenge_30_day;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * @author sudhir on 21-Apr-2020
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int cursum = 0;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (cursum + nums[i] <= nums[i]) {
                cursum = nums[i];
            } else {
                cursum += nums[i];
            }
            if (cursum > maxsum) {
                maxsum = cursum;
            }
        }
        return maxsum;
    }
}
