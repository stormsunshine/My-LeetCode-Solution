/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null)
            return new ListNode[k];
        if (k == 1)
            return new ListNode[]{root};
        int length = 0;
        ListNode counter = root;
        while (counter != null) {
            counter = counter.next;
            length++;
        }
        int[] sizes = new int[k];
        int size = length / k;
        for (int i = 0; i < k; i++)
            sizes[i] = size;
        int remainder = length % k;
        for (int i = 0; i < remainder; i++)
            sizes[i]++;
        ListNode[] array = new ListNode[k];
        ListNode head = root;
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            array[i] = head;
            temp = head;
            int curSize = sizes[i];
            for (int j = 1; j <= curSize; j++) {
                if (j == curSize) {
                    head = temp.next;
                    temp.next = null;
                } else
                    temp = temp.next;
            }
        }
        return array;
    }
}