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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh - rh) > 1) return false;
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        
        return left && right;
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height (root.right);
        
        return Math.max(left, right) +1;
    }
}

Time complexity : O(N2)

optimal approach

public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        if(findH(root)==-1) return false;
        return true;
    }
    
    private int findH( TreeNode root){
        if(root==null) return 0;
        
        int l = findH(root.left);
        if(l==-1) return -1;
        int r= findH( root.right);
        if(r==-1) return -1;
        
        if(Math.abs(l -r ) > 1) return -1;
        
        return 1 + Math.max(l, r);
    }

