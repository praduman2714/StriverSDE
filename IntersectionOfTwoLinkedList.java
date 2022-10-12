/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hs = new HashSet<>();
        ListNode temp = headA;
        while(temp != null){
            hs.add(temp);
            temp =temp.next;
        }
        
        temp = headB;
        while(temp != null){
            if(hs.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
} 
Time Complexity : O(N+M)
Space Complexity : O(N)

Another Approach
For this approach follow : https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        int c = 0;
        while(temp != null){
            c++;
            temp = temp.next;
        }
        temp = headB;
        int c1 = 0;
        while(temp != null){
            c1++;
            temp = temp.next;
        }
        ListNode temp2;
        if(c > c1){
            temp = headA;
            temp2 = headB;
        }else {
            temp = headB;
            temp2 = headA;
        }
        int diff = Math.abs(c - c1);
        while(diff > 0){
            temp = temp.next;
            diff--;
        }
        
        while(temp != null){
            if(temp == temp2){
                return temp;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        
        return null;
        
    }
}
Optimize Approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        
        while(d1 != d2){
            d1 = d1 == null ? headA : d1.next;
            d2 = d2 == null ? headB : d2.next;
        }
        return d2;
    }
}