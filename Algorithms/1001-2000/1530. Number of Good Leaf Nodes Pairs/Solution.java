/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        if (root == null || isLeaf(root))
            return 0;
        Map<TreeNode, String> map = new HashMap<TreeNode, String>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();
        nodeQueue.offer(root);
        pathQueue.offer("");
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (isLeaf(node))
                map.put(node, path);
            else {
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    nodeQueue.offer(left);
                    pathQueue.offer(path + "0");
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    pathQueue.offer(path + "1");
                }
            }
        }
        int pairs = 0;
        List<TreeNode> leafList = new ArrayList<TreeNode>(map.keySet());
        int size = leafList.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode leaf1 = leafList.get(i);
            String path1 = map.get(leaf1);
            for (int j = i + 1; j < size; j++) {
                TreeNode leaf2 = leafList.get(j);
                String path2 = map.get(leaf2);
                if (distance(path1, path2) <= distance)
                    pairs++;
            }
        }
        return pairs;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int distance(String path1, String path2) {
        int length1 = path1.length(), length2 = path2.length();
        int minLength = Math.min(length1, length2);
        int differentIndex = -1;
        for (int i = 0; i < minLength; i++) {
            if (path1.charAt(i) != path2.charAt(i)) {
                differentIndex = i;
                break;
            }
        }
        if (differentIndex < 0)
            return 0;
        else
            return length1 + length2 - differentIndex * 2;
    }
}