/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp1 = l1, temp2 = l2, tempMerge = dummyHead;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                tempMerge.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                tempMerge.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            tempMerge = tempMerge.next;
        }
        while (temp1 != null) {
            tempMerge.next = new ListNode(temp1.val);
            temp1 = temp1.next;
            tempMerge = tempMerge.next;
        }
        while (temp2 != null) {
            tempMerge.next = new ListNode(temp2.val);
            temp2 = temp2.next;
            tempMerge = tempMerge.next;
        }
        return dummyHead.next;
    }
}