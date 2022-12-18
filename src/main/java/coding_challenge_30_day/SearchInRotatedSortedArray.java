package coding_challenge_30_day;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.<br/>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).<br/>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.<br/>
 * You may assume no duplicate exists in the array.<br/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * @author sudhir on 27-Apr-2020
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (high < low) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid + 1] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(s.search(nums, target));
    }

}
