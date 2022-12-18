package coding_challenge_30_day;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * @author sudhir on 23-Apr-2020
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length + 1];
        prefixProduct[0] = 1;
        int[] suffixProduct = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixProduct[i + 1] = prefixProduct[i] * nums[i];
        }
        suffixProduct[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(p.productExceptSelf(nums)));
    }
}
