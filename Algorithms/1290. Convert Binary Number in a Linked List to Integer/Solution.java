/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int decimalValue = 0;
        ListNode temp = head;
        while (temp != null) {
            decimalValue <<= 1;
            decimalValue += temp.val;
            temp = temp.next;
        }
        return decimalValue;
    }
}