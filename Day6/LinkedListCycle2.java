The first approach is Using Hash Table, that will take a extra memory
The optimal Approach

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        //System.out.println(fast.val + " " + slow.val);
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}