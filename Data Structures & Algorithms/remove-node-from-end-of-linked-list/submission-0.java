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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
     for(int i=0;i<n;i++){
        temp=temp.next;
     }
     ListNode ptr=dummy;
     while(temp.next!=null){
        temp=temp.next;
       ptr=ptr.next;
     }
     ptr.next=ptr.next.next;
     return dummy.next;
    }
}
