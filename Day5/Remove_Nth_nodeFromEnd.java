// Optizime Code
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode st = new ListNode(-1);
        st.next = head;
        ListNode fast = st;
        ListNode slow = st;
        for(int i = 0; i<n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
            
        }
        slow.next = slow.next.next;
        return st.next;
    }
}

For another method follow your own code.
