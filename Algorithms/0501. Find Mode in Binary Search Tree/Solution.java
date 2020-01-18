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
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        Map<Integer, Integer> countsMap = new HashMap<Integer, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int value = node.val;
            int count = countsMap.getOrDefault(value, 0);
            count++;
            countsMap.put(value, count);
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        int maxCount = 0;
        Map<Integer, List<Integer>> countValuesMap = new HashMap<Integer, List<Integer>>();
        Set<Integer> valuesSet = countsMap.keySet();
        for (int value : valuesSet) {
            int count = countsMap.get(value);
            maxCount = Math.max(maxCount, count);
            List<Integer> values = countValuesMap.getOrDefault(count, new ArrayList<Integer>());
            values.add(value);
            countValuesMap.put(count, values);
        }
        List<Integer> maxCountValues = countValuesMap.get(maxCount);
        int length = maxCountValues.size();
        int[] modes = new int[length];
        for (int i = 0; i < length; i++)
            modes[i] = maxCountValues.get(i);
        return modes;
    }
}