/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
       // System.out.println(node.val + " " + temp.val);
        node.val = temp.val;
        //System.out.println(node.val + " " + temp.val);
        node.next = temp.next;
        temp.next = null;
    }
}