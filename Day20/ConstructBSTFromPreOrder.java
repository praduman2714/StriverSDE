The first and the naive approach will be taking one number and checking its correct position
It will take O(N^2) time.

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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] in = new int[preorder.length];
        int ii =0;
        for(int val : preorder){
            in[ii++] = val;
        }
        Arrays.sort(in);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<in.length; i++){
            map.put(in[i] , i);
        }
        return buildTree(in, 0, in.length - 1, preorder, 0, preorder.length - 1, map);
    }
    
    public TreeNode buildTree(int[] in, int is, int ie, int[] pre, int ps, int pe , Map<Integer, Integer> map){
        if(is > ie || ps > pe) return null;
        //int root = pre[ps];
        //int rp = map.get(pre[ps]);
        
        TreeNode root = new TreeNode(pre[ps]);
        
        int rp = map.get(pre[ps]);
        int lef = rp - is;
        
        root.left = buildTree(in, is, rp - 1, pre, ps+1, ps+lef, map);
        root.right = buildTree(in , rp+1, ie, pre, ps+lef+1, pe, map);
        return root;
        
    }
}

Time Complexity : O(N log N)


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
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, new int[]{0} , Integer.MAX_VALUE);
    }
    
    public TreeNode buildTree(int[] pre, int[] st, int bound){
        if(st[0] == pre.length || pre[st[0]] > bound) return null;
        
        TreeNode root = new TreeNode(pre[st[0]++]);
        root.left = buildTree(pre, st, root.val);
        root.right = buildTree(pre, st, bound);
        return root;
    }
}

Time complexity : O(N)