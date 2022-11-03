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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        inorder(root, al);
        return al;
    }
    
    public void inorder(TreeNode root, List<Integer> al){
        if(root == null) return ;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
}

Complexity Analysis

Time complexity: O(n)O(n)

The time complexity is O(n)O(n) because the recursive function is T(n) = 2 \cdot T(n/2)+1T(n)=2⋅T(n/2)+1.
Space complexity: O(n)O(n)

The worst case space required is O(n)O(n), and in the average case it's O(\log n)O(logn) where nn is number of nodes.


Iteravtive Approach

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        //st.add(curr);
        
        while(true){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                if(st.isEmpty()) break;
                curr = st.peek();
                al.add(curr.val);
                st.pop();
                curr= curr.right;
            }
        }
        return al;
        
    }
}

Time and space is :O(N)
    
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                al.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    al.add(curr.val);
                    curr = curr.right;    
                }
            }
        }
        return al;
    }
}


This approach is know as morish traversal, which use the concept of threaded binary tree and take the constant space
    
