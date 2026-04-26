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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> p_tree = new LinkedList<>();
        Queue<TreeNode> q_tree = new LinkedList<>();
        p_tree.add(p);
        q_tree.add(q);

        while (!p_tree.isEmpty() && !q_tree.isEmpty()) {
            for (int i = p_tree.size(); i > 0; i--) {
                TreeNode pNode = p_tree.poll();
                TreeNode qNode = q_tree.poll();

                if (pNode == null && qNode == null) {
                    continue;
                }
                if (pNode == null || qNode == null || pNode.val != qNode.val) {
                    return false;
                }

                q_tree.add(qNode.left);
                q_tree.add(qNode.right);
                p_tree.add(pNode.left);
                p_tree.add(pNode.right);
            }
        }
        return true;
    }
}
