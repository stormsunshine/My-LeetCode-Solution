/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> subset = new HashSet<Integer>();
        for (int value : G)
            subset.add(value);
        boolean inComponent = false;
        int components = 0;
        ListNode node = head;
        while (node != null) {
            int value = node.val;
            if (subset.contains(value)) {
                if (!inComponent) {
                    inComponent = true;
                    components++;
                }
            } else {
                if (inComponent)
                    inComponent = false;
            }
            node = node.next;
        }
        return components;
    }
}