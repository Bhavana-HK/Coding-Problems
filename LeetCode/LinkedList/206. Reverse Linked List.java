// https://leetcode.com/problems/reverse-linked-list/

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

// iterative solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        
        ListNode prev = null, next;
        
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}

// recursive solution
class Solution {
    public static ListNode head = null;
    public void reverse(ListNode prev, ListNode cur){
        if(cur != null){
            reverse(cur, cur.next);
            cur.next = prev;
        }
        else
            head = prev;
    }
    
    public ListNode reverseList(ListNode head) {
        this.head = head;
        reverse(null, head);
        return this.head;
    }
}