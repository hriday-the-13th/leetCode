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
    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(hare == tortoise){
                return true;
            }
        }

        return false;
    }
}