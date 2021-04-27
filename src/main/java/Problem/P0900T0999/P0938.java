package Problem.P0900T0999;

/**
 * Time  : 2021/4/27 09:39
 * Author: Banehallow
 */
public class P0938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root != null) {
            int sum = 0;
            if (root.val >= low && root.val <= high) sum += root.val;
            if (root.val > low) sum += rangeSumBST(root.left, low, high);
            if (root.val < high) sum += rangeSumBST(root.right, low, high);
            return sum;
        }
        return 0;
    }
}
