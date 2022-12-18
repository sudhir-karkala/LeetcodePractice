package september_challenge;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * <p>
 * The smallest 24 hour time is 00:00, and the largest is 23:59.
 * Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * <p>
 * Return the answer as a string of length 5.
 * If no valid time can be made, return an empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4]
 * <p>
 * Output: "23:41"
 * <p>
 * Example 2:
 * <p>
 * Input: [5,5,5,5]
 * <p>
 * Output: ""
 * <p>
 * Note:
 * <p>
 * A.length == 4
 * <p>
 * 0 <= A[i] <= 9
 *
 * @author sudhir on 01-Sep-2020
 */
public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        int time = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    for (int l = 0; l < 4; l++) {
                        if (i == l || j == l || k == l) {
                            continue;
                        }
                        int hour = A[i] * 10 + A[j];
                        int min = A[k] * 10 + A[l];
                        if (hour < 24 && min < 60) {
                            time = Math.max(time, hour * 60 + min);
                        }
                    }
                }
            }
        }
        return time == -1 ? "" : String.format("%02d", time / 60) + ":"
                + String.format("%02d", time % 60);
    }

    public static void main(String[] args) {
        LargestTimeForGivenDigits ltfgd = new LargestTimeForGivenDigits();
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {5, 5, 5, 5};
        int[] a3 = {0, 0, 0, 0};
        System.out.println(ltfgd.largestTimeFromDigits(a1));
        System.out.println(ltfgd.largestTimeFromDigits(a2));
        System.out.println(ltfgd.largestTimeFromDigits(a3));
    }
}
