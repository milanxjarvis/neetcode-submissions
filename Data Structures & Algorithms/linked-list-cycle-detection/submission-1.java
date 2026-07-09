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
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        while(fastPtr!=null){
         
         slowPtr=slowPtr.next;
         if(fastPtr.next!=null){
             fastPtr=fastPtr.next.next;
         }
         else{
            return false;
         }
        
         if(slowPtr==fastPtr){
            return true;
         }
        }
        return false;
    }
}
