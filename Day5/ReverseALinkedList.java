// Recursive Method
Time Complexity : O(N)
Space Complexity : Apart form extra stack space it is not useing
any space

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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        return reverse(head, prev);
    }
    
    public ListNode reverse(ListNode head, ListNode prev){
        if(head == null) return prev;
        ListNode curr = head.next;
        head.next = prev;
        prev = head;
        head = curr;
        return reverse(head, prev);
    }
}

Iterative method
Time Complexity : O(N)
SPACE COMPLEXITY : O(1)
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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        //ListNode temp = head;
        while(head != null){
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        
        return prev;
    }
}