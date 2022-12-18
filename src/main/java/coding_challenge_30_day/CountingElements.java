package coding_challenge_30_day;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.<br/>
 * If there're duplicates in arr, count them separately.
 *
 * @author sudhir on 21-Apr-2020
 */
public class CountingElements {
    /*
        1.
        Input: arr = [1,1,2,2]
        Output: 2
        Explanation: Two 1s are counted cause 2 is in arr.

        2.
        Input: arr = [1,1,3,3,5,5,7,7]
        Output: 0
        Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

        3.
        Input: arr = [1,2,3]
        Output: 2
        Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
     */
    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] + 1)) {
                count++;
            }
        }
        return count;
    }
}
