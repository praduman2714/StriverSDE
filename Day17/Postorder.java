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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        //st.push(curr);
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    TreeNode tt = st.pop();
                    al.add(tt.val);
                     while (!st.isEmpty() && tt == st.peek().right) {
                        tt = st.peek();
                        st.pop();
                        al.add(tt.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return al;
    }
}


come on you knwo the compleaxity and can write the recursive solution right.