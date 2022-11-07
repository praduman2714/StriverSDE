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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0 || nums == null)  return null;
        
        return constructBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructBST(int[] nums, int left , int right){
        if(left > right) return null;
        
        int mid = left +(right - left)/2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = constructBST(nums, left, mid-1);
        curr.right = constructBST(nums, mid+1, right);
        return curr;
    }
}