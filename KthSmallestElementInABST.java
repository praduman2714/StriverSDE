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
        List<Integer> al = new ArrayList<>();
        inorder(root, al);
        return al.get(k-1);
    }
    
    public void inorder(TreeNode root, List<Integer> al){
        if(root == null) return ;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
}

Iterative approach

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
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        
        while(true){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            
             curr = st.pop();
            if(--k == 0) return curr.val;
            curr = curr.right;
        }
        
        
    }
}