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
    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0)
            return new ArrayList<TreeNode>();
        Map<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
        List<TreeNode> oneList = new ArrayList<TreeNode>();
        oneList.add(new TreeNode(0));
        map.put(1, oneList);
        for (int i = 3; i <= N; i += 2) {
            List<TreeNode> curList = map.getOrDefault(i, new ArrayList<TreeNode>());
            int sum = i - 1;
            for (int left = 1; left < sum; left++) {
                int right = sum - left;
                List<TreeNode> leftList = map.getOrDefault(left, new ArrayList<TreeNode>());
                List<TreeNode> rightList = map.getOrDefault(right, new ArrayList<TreeNode>());
                for (TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftNode;
                        root.right = rightNode;
                        curList.add(root);
                    }
                }
            }
            map.put(i, curList);
        }
        return map.get(N);
    }
}