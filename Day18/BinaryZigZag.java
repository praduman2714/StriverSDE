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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        insert(root, res, 0);
        return res;
    }
    
    public void insert(TreeNode root, List<List<Integer>> res , int level){
       // List<Integer> al = new ArrayList<>();
        if(root == null) return;
        if(level == res.size()) res.add(new ArrayList<>());
        if(level % 2 == 0){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0, root.val);
        }
        
        insert(root.left, res, level+1);
        insert(root.right, res, level + 1);
        
    }
}

Time complexity : O(N) and constant space complexity

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i = 0; i<len ; i++){
                TreeNode node = q.poll();
                al.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(level%2 == 1){
                Collections.reverse(al);
            }
            res.add(al);
            level++;
        }
        return res;
    }
}

Time and Space : O(N)
