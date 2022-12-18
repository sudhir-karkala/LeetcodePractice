package coding_challenge_30_day;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.<br/>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:<br/>
 * If x == y, both stones are totally destroyed;<br/>
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.<br/>
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)<br/>
 *
 * @author sudhir on 21-Apr-2020
 */
public class LastStoneWeight {
    /*
        Input: [2,7,4,1,8,1]
        Output: 1
        Explanation:
        We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());
        for (Integer num : stones) {
            pq.add(num);
        }
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int result = Math.abs(num1 - num2);
            if (result != 0) {
                pq.add(result);
            }
        }
        if (pq.size() == 0) {
            return 0;
        }
        return pq.poll();
    }
}
