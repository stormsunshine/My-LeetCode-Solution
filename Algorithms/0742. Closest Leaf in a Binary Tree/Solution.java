/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(root.val, "");
        Set<Integer> leaves = new HashSet<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String path = map.getOrDefault(node.val, "");
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null)
                leaves.add(node.val);
            else {
                if (left != null) {
                    String leftPath = path + "0";
                    map.put(left.val, leftPath);
                    queue.offer(left);
                }
                if (right != null) {
                    String rightPath = path + "1";
                    map.put(right.val, rightPath);
                    queue.offer(right);
                }
            }
        }
        String nodePath = map.getOrDefault(k, "");
        int leafVal = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int leaf : leaves) {
            String leafPath = map.getOrDefault(leaf, "");
            int distance = distance(nodePath, leafPath);
            if (distance < minDistance) {
                leafVal = leaf;
                minDistance = distance;
            }
        }
        return leafVal;
    }

    public int distance(String path1, String path2) {
        int length1 = path1.length(), length2 = path2.length();
        int minLength = Math.min(length1, length2);
        int differentIndex = 0;
        while (differentIndex < minLength) {
            char c1 = path1.charAt(differentIndex), c2 = path2.charAt(differentIndex);
            if (c1 == c2)
                differentIndex++;
            else
                break;
        }
        int distance = length1 - differentIndex + length2 - differentIndex;
        return distance;
    }
}