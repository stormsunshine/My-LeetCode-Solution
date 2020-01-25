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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, String> nodePathMap = new HashMap<TreeNode, String>();
        nodePathMap.put(root, "");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String path = nodePathMap.getOrDefault(node, "");
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                nodePathMap.put(left, path + "0");
                queue.offer(left);
            }
            if (right != null) {
                nodePathMap.put(right, path + "1");
                queue.offer(right);
            }
        }
        String targetPath = nodePathMap.getOrDefault(target, "");
        List<Integer> valuesList = new ArrayList<Integer>();
        Set<TreeNode> set = nodePathMap.keySet();
        for (TreeNode node : set) {
            String path = nodePathMap.getOrDefault(node, "");
            if (distance(targetPath, path) == K)
                valuesList.add(node.val);
        }
        return valuesList;
    }

    public int distance(String path1, String path2) {
        int length1 = path1.length(), length2 = path2.length();
        int minLength = Math.min(length1, length2);
        int startIndex = 0;
        while (startIndex < minLength) {
            char c1 = path1.charAt(startIndex), c2 = path2.charAt(startIndex);
            if (c1 != c2)
                break;
            startIndex++;
        }
        int distance = length1 - startIndex + length2 - startIndex;
        return distance;
    }
}