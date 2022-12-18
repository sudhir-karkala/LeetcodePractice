package coding_challenge_30_day;

import java.util.List;

/**
 * This interface is only used by the coding problem below
 * @see LeftmostColumnWithAtLeastAOne
 *
 * @author sudhir on 27-Apr-2020
 */
public interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}