import java.util.Arrays;

public class P0105 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0)
            return null;
        int val = preorder[0];
        TreeNode t = new TreeNode();
        t.val = val;
        if (len == 1)
            return t;
        int i = 0;
        while (inorder[i] != val) i++;
        t.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1 ),  Arrays.copyOfRange(inorder, 0, i));
        t.right = buildTree(Arrays.copyOfRange(preorder, i + 1, len), Arrays.copyOfRange(inorder, i+1, len));
        return t;
    }

    public static void main(String[] args) {
        P0105 solution = new P0105();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode t = solution.buildTree(preOrder, inOrder);
        System.out.println(t);
    }
}
