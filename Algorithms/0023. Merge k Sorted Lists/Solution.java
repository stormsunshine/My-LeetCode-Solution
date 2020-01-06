/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        int length = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        boolean[] toEnd = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (lists[i] == null)
                toEnd[i] = true;
        }
        int endCount = 0;
        while (endCount < length) {
            int index = 0;
            while (index < length && toEnd[index])
                index++;
            if (index == length)
                break;
            int minIndex = index;
            int minValue = lists[index].val;
            for (int i = index + 1; i < length; i++) {
                if (toEnd[i])
                    continue;
                int curValue = lists[i].val;
                if (curValue < minValue) {
                    minIndex = i;
                    minValue = curValue;
                }
            }
            ListNode nextNode = new ListNode(minValue);
            temp.next = nextNode;
            temp = nextNode;
            lists[minIndex] = lists[minIndex].next;
            if (lists[minIndex] == null)
                toEnd[minIndex] = true;
        }
        return dummyHead.next;
    }
}