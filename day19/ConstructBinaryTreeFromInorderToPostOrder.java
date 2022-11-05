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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ;i<inorder.length ; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length -1, map);
    }
    
    public TreeNode build(int[] in, int is, int ie, int[] post, int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe) return null;
        
        TreeNode root = new TreeNode(post[pe]);
        int inRoot = map.get(root.val);
        int numLeft = ie - inRoot;
        
        root.left = build(in, is, inRoot - 1, post, ps, pe - numLeft - 1, map);
        root.right = build(in, inRoot + 1, ie, post, pe - numLeft, pe - 1 , map);
        return root;
        
    }
}
