/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
       Node left = root.left;
        Node right = root.right;
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

Time complexity : O(N)
space complexity : O(log n) stack Space;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node node = root;
       Queue<Node> q = new LinkedList<>(); 
       q.add(node);
        while(!q.isEmpty()){
            Node temp = null;
           // Node prev = q.poll();
            int len = q.size();
            for(int i = 0; i<len; i++){
                Node prev = q.poll();
                if(i == 0){
                    temp = prev;
                }else{
                    temp.next = prev;
                    temp = prev;
                }
                if(prev.left != null) q.add(prev.left);
                if(prev.right != null) q.add(prev.right);
            }
        }
        return node;
    }
}