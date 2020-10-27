import java.util.ArrayList;
import java.util.List;

/**
 * Date  :  2020/10/27
 * Author:  YiPing, Wei
 * 递归
 **/
public class P0144 {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        if (root!=null) {
            re.add(root.val);
            if (root.left!=null)
                re.addAll(preorderTraversal(root.left));
            if (root.right!=null)
                re.addAll(preorderTraversal(root.right));
        }
        return re;
    }
}
