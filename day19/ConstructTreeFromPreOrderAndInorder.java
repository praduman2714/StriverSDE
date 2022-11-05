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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length ; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }
    
    public TreeNode buildTree(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> map){
        if(ps > pe || is > ie) return null;
        
        TreeNode root = new TreeNode(pre[ps]);
        int inroot = map.get(root.val);
        int le = inroot - is;
        
        root.left = buildTree(pre, ps+1, ps + le, in, is, inroot-1, map);
        root.right = buildTree(pre, ps + le + 1, pe, in , inroot + 1, ie, map);
        return root;
    }
}

