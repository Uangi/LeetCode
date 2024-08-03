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
    public TreeNode searchBST(TreeNode root, int val) {
        // root가 null인 경우, 즉 트리가 비어있는 경우
        if (root == null) {
            return null;
        }
        
        // 현재 노드의 값이 찾고자 하는 값과 같으면 현재 노드를 반환
        if (root.val == val) {
            return root;
        }
        
        // 현재 노드의 값이 찾고자 하는 값보다 크면 왼쪽 서브트리에서 탐색
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        
        // 현재 노드의 값이 찾고자 하는 값보다 작으면 오른쪽 서브트리에서 탐색
        return searchBST(root.right, val);
    }
}