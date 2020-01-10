/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return mergeSort(head, null);
    }

    public ListNode mergeSort(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast != tail)
                fast = fast.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode node1 = mergeSort(head, mid);
        ListNode node2 = mergeSort(mid, tail);
        return merge(node1, node2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        while (temp1 != null) {
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return dummyHead.next;
    }
}