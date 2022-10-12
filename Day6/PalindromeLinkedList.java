The first approach is using any dataStructure, In that method first we'll store all the element
in the data structure and then check if it is palindrome or not

Time Complexity : O(N)
Space Coplexity : O(N)
Solution : https://leetcode.com/submissions/detail/820657223/

Another Approach
Time Complexity : O(N)
Space Complexity : O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //System.out.println(slow.val +  " " + fast.val);
        
        slow.next = reverse(slow.next);
        
        slow = slow.next;
        ListNode temp = head;
        
        while(slow != null){
            if(slow.val != temp.val){
                return false;
            }
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode node){
        ListNode temp = null;
        
        while(node != null){
            ListNode curr = node.next;
            node.next = temp;
            temp = node;
            node = curr;
        }
       return  temp;
    }
}