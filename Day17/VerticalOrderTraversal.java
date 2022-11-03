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
    class Pair{
        TreeNode node; int row, col;
        Pair(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>> > map = new TreeMap<>();
        q.add(new Pair(root, 0, 0));
        
        while(q.isEmpty() == false){
            int len = q.size();
            for(int i = 0; i<len; i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int row = p.row;
                int col = p.col;
                
                if(!map.containsKey(row)){
                    map.put(row, new TreeMap<>());
                }
                if(!map.get(row).containsKey(col)){
                    map.get(row).put(col, new PriorityQueue<>());
                }
                
                map.get(row).get(col).add(node.val);
                
                if(node.left != null) q.add(new Pair(node.left, row-1, col +1));
                if(node.right != null) q.add(new Pair(node.right , row +1 , col+1));
            }
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer>pq : ys.values()){
                while(!pq.isEmpty()){
                    res.get(res.size() - 1).add(pq.poll());
                }
            }
        }
        return res;
    }
}

Time complexity : O(N)
Space Complexity : O(N)
