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
    // Time Complexity : O(N + M);
    // Space Complexity : O(N + M);
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        while(list1 != null){
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;
        }
        
        while(list2 != null){
            curr.next = list2;
            curr= curr.next;
            list2 = list2.next;
        }
        return res.next;
    }
}

Space Optimize Approach
In this approach we use a constant approach

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val > list2.val) {
            ListNode t = list1;
            list1 = list2;
            list2 = t;
        }
        
        ListNode res = list1;
        
        while(list1 != null && list2 != null){
            ListNode temp = null;
            while(list1 != null && list1.val <= list2.val){
                temp = list1;
                list1 =list1.next;
            }
            temp.next = list2;
            ListNode t = list1;
            list1 = list2;
            list2 = t;
            
        }
        return res;   
    }
}