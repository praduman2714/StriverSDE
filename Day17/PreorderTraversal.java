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
    
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null){
            List<Integer> al = new ArrayList<>();
            return al;
        }
        
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
        return list;
    }
}

complexity ; O(N) for both

This is the iterative method

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        if(curr == null) return al;
        st.push(curr);
        while(!st.isEmpty()){
            TreeNode cc = st.pop();
            if(cc != null) al.add(cc.val);
            if(cc.right != null) st.push(cc.right);
            if(cc.left != null) st.push(cc.left);
        }
        return al;
    }
}