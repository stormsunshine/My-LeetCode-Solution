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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
        Map<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodesList.add(node);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                childParentMap.put(left, node);
                queue.offer(left);
            }
            if (right != null) {
                childParentMap.put(right, node);
                queue.offer(right);
            }
        }
        int maxCount = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<Integer, Integer>();
        for (int i = nodesList.size() - 1; i >= 0; i--) {
            TreeNode node = nodesList.get(i);
            TreeNode parent = childParentMap.get(node);
            if (parent != null)
                parent.val += node.val;
            int value = node.val;
            int count = sumCountMap.getOrDefault(value, 0);
            count++;
            maxCount = Math.max(maxCount, count);
            sumCountMap.put(value, count);
        }
        List<Integer> frequentSumsList = new ArrayList<Integer>();
        Set<Integer> valuesSet = sumCountMap.keySet();
        for (int value : valuesSet) {
            int count = sumCountMap.getOrDefault(value, 0);
            if (count == maxCount)
                frequentSumsList.add(value);
        }
        int length = frequentSumsList.size();
        int[] frequentSums = new int[length];
        for (int i = 0; i < length; i++)
            frequentSums[i] = frequentSumsList.get(i);
        return frequentSums;
    }
}