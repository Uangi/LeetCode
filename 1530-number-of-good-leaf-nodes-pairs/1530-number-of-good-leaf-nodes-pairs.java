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
public class Solution {
    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null) {
            return new int[distance + 1];
        }
        
        if (node.left == null && node.right == null) {
            int[] leaves = new int[distance + 1];
            leaves[1] = 1;  // Leaf node at distance 1 from itself
            return leaves;
        }
        
        int[] leftLeaves = dfs(node.left, distance, result);
        int[] rightLeaves = dfs(node.right, distance, result);
        
        // Count good leaf pairs between left and right subtrees
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result[0] += leftLeaves[i] * rightLeaves[j];
                }
            }
        }
        
        // Prepare the leaf distances for the current node
        int[] leaves = new int[distance + 1];
        for (int i = 2; i <= distance; i++) {
            leaves[i] = leftLeaves[i - 1] + rightLeaves[i - 1];
        }
        
        return leaves;
    }
}