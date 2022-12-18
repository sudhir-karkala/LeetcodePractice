package coding_challenge_30_day;

/**
 * @author sudhir on 21-Apr-2020
 */
public class DiameterOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private int answer = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return answer;
        }
        int heightOfTree = findHeight(root);
        return answer;
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int hl = findHeight(root.left);
        int hr = findHeight(root.right);
        answer = Math.max(answer, hl + hr + 2);
        return Math.max(hl, hr) + 1;
    }
}
