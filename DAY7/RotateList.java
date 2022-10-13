The brute force approach is that we can travel for each k node and make them head.

The optimal approach is:
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null) return head;
        
        int c = 1;
        ListNode temp = head;
        while(temp.next != null){
            c++;
            temp = temp.next; 
            
        }
        k =k % c;
        temp.next = head;
        int len = c - k;
        //temp = head;
        while(len -- > 0){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
        
    }
}

For more follow this Like : https://takeuforward.org/data-structure/rotate-a-linked-list/
