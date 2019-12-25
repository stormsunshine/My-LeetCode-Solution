/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp1 = l1, temp2 = l2, curr = dummyHead;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int num1 = (temp1 != null) ? temp1.val : 0;
            int num2 = (temp2 != null) ? temp2.val : 0;
            int sum = carry + num1 + num2;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);
        return dummyHead.next;
    }
}