/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        TreeNode dummy = new TreeNode(0);
        TreeNode current = dummy;
        
        for (TreeNode node : nodes) {
            node.left = null;
            current.right = node;
            current = node;
        }
        
        return dummy.right;
    }

    private void inorderTraversal(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nodes);
        nodes.add(node);
        inorderTraversal(node.right, nodes);
    }
}