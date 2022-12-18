package coding_challenge_30_day;

/**
 * @author sudhir on 21-Apr-2020
 */
public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        // calculate cumulative number of shifts to be done
        int leftShifts = 0;
        int rightShifts = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                leftShifts += shift[i][1];
            } else {
                rightShifts += shift[i][1];
            }
        }
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        int count = 0;
        leftShifts %= n;
        rightShifts %= n;
        leftShifts *= -1;// assign -1 to each left shift
        int totalShifts = leftShifts + rightShifts;
        if (totalShifts < 0) {
            for (int j = -totalShifts; count < n; j = (j + 1) % n) {
                builder.append(s.charAt(j));
                count++;
            }
        } else if (totalShifts > 0) {
            for (int j = (n - totalShifts) % n; count < n; j = (j + 1) % n) {
                builder.append(s.charAt(j));
                count++;
            }
        } else { // no shifts needed. return the original string
            return s;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        PerformStringShifts p = new PerformStringShifts();
        int[][] shifts = {{1, 1}, {1, 6}, {0, 1}, {1, 3}, {1, 0}, {0, 3}};
        String str = "joiazl";
        System.out.println(p.stringShift(str, shifts));
    }
}
