package Problem.P0800T0899;

import java.util.ArrayList;
import java.util.List;

/**
 * Time  : 2021/5/10 18:14
 * Author: Banehallow
 */
public class P0872 {
    static class TreeNode {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        calLeaf(root1, leaves1);
        calLeaf(root2, leaves2);
        if (leaves1.size()!=leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (!leaves1.get(i).equals(leaves2.get(i))) return false;
        }
        return true;
    }

    private void calLeaf(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        } else {
            calLeaf(node.left, leaves);
            calLeaf(node.right, leaves);
        }
    }
}
