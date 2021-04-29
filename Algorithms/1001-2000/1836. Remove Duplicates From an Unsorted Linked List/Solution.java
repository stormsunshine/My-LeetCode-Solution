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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode temp = head;
        while (temp != null) {
            int val = temp.val;
            map.put(val, map.getOrDefault(val, 0) + 1);
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        temp = dummyHead;
        while (temp.next != null) {
            ListNode next = temp.next;
            int nextVal = next.val;
            if (map.get(nextVal) > 1)
                temp.next = next.next;
            else
                temp = temp.next;
        }
        return dummyHead.next;
    }
}