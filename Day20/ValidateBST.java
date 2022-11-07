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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE , Long.MAX_VALUE );
    }
    
     boolean helper(TreeNode root, long min, long max){
        if(root==null)
            return true;
        if(root.val<=min || root.val>=max)
            return false;
        //update the lower bound for right subtree and upper bound for left subtree
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

One more approach is that find the the in order of the the tree and check whether it is in 
sorted order or not.
