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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) { 
            return null;
        }
        if (Math.max(p.val, q.val) < root.val) { // search values are less than root so search left
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (Math.min(p.val, q.val) > root.val) { // search values are more than root so search right 
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root; // root is either p/q/inbetween pq
        }
    }
}
