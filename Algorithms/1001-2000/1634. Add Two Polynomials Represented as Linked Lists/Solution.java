/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummyHead = new PolyNode();
        PolyNode node = dummyHead;
        PolyNode node1 = poly1, node2 = poly2;
        while (node1 != null && node2 != null) {
            if (node1.power == node2.power) {
                int nextCoefficient = node1.coefficient + node2.coefficient;
                int nextPower = node1.power;
                if (nextCoefficient != 0) {
                    PolyNode nextNode = new PolyNode(nextCoefficient, nextPower);
                    node.next = nextNode;
                    node = node.next;
                }
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1.power > node2.power) {
                PolyNode nextNode = new PolyNode(node1.coefficient, node1.power);
                node.next = nextNode;
                node = node.next;
                node1 = node1.next;
            } else {
                PolyNode nextNode = new PolyNode(node2.coefficient, node2.power);
                node.next = nextNode;
                node = node.next;
                node2 = node2.next;
            }
        }
        if (node1 != null)
            node.next = node1;
        else if (node2 != null)
            node.next = node2;
        return dummyHead.next;
    }
}