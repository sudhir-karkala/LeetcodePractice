package coding_challenge_30_day;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.<br/>
 * Note:<br/>
 * You must do this in-place without making a copy of the array. Minimize the total number of operations.
 *
 * @author sudhir on 21-Apr-2020
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
