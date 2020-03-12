/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node temp = head;
        List<Node> originalList = new ArrayList<Node>();
        List<Node> copyList = new ArrayList<Node>();
        while (temp != null) {
            originalList.add(temp);
            copyList.add(new Node(temp.val));
            temp = temp.next;
        }
        int size = copyList.size();
        for (int i = 1; i < size; i++)
            copyList.get(i - 1).next = copyList.get(i);
        for (int i = 0; i < size; i++) {
            Node originalNode = originalList.get(i);
            Node originalRandom = originalNode.random;
            if (originalRandom != null) {
                int index = originalList.indexOf(originalRandom);
                copyList.get(i).random = copyList.get(index);
            }
        }
        return copyList.get(0);
    }
}