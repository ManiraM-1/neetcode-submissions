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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        inorder(root,pq);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.poll();
    }
    private void inorder(TreeNode root, PriorityQueue<Integer> ans){
        if(root==null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
