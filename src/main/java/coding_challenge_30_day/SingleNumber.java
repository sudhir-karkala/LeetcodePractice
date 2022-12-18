package coding_challenge_30_day;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * @author sudhir on 21-Apr-2020
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }
}
