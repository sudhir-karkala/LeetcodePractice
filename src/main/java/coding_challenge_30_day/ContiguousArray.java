package coding_challenge_30_day;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * @author sudhir on 21-Apr-2020
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        //map to store sum and ending index.
        Map<Integer, Integer> map = new HashMap<>();
        // The initial sum of the array can be thought of as 0.
        // So if the sum ever hits 0, the corresponding array segment length would be from the start of the array
        // to the current index, which would be equal to the current index + 1
        // (e.g. at index 1 this would correspond to a contiguous subarray of length 2).
        // Example case: [0,1]
        // Initializing map to (0, -1) avoids cases like [0,1] when you only have one zero and a one.
        // Without initializing, the laxLen would return 0 instead of 2.
        map.put(0, -1);
        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(sum)) {
                maxlen = Math.max(maxlen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}
