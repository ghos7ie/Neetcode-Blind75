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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        if (root != null) {
            bfs.add(root);
        }

        int level = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size(); // get current size so that can pop up until current level is done
            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();
                if (curr.left != null) {
                    bfs.add(curr.left);
                }
                if (curr.right != null) {
                    bfs.add(curr.right);
                }
            }
            level++;
        } 
        return level;
    }
}
