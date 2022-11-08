import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        int low = 0, high = al.size()-1;
        int res = -1;
        while(low <= high){
            int mid = (low + high)>>1;
            if(al.get(mid) <= X){
                res = al.get(mid);
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
    
    public static void inorder(TreeNode<Integer> root, ArrayList<Integer> al ){
        if(root == null) return ;
        inorder(root.left, al);
        al.add(root.data);
        inorder(root.right, al);
    }
}

Time Complextiy : O(N)
Space complexity : O(N)

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        if(root == null) return Integer.MAX_VALUE;
        if(root.data == X) return root.data;
        if(root.data > X){
            return floorInBST(root.left, X);
        }
        int floor = floorInBST(root.right, X);
        return floor <= X ? floor : root.data;
    }
}

Time complexity : O(Height)
Space complexity : O(1)


