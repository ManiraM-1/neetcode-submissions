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
    int maxdiam  = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxht(root);
        return maxdiam;
    }
    int maxht(TreeNode root){
        if(root == null) return 0;
        TreeNode l =  root.left;
        TreeNode r = root.right;
        int ans = 1  + Math.max(maxht(l),maxht(r));
        maxdiam = Math.max(maxdiam, maxht(l)+maxht(r));
        return ans;
    }
}
