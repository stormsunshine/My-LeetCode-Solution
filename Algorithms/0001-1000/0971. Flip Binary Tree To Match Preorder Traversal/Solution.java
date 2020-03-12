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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null)
            return new ArrayList<Integer>();
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = voyage.length;
        for (int i = 0; i < length; i++)
            indexMap.put(voyage[i], i);
        List<Integer> flipList = new ArrayList<Integer>();
        int voyageIndex = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (voyageIndex >= length)
                return new ArrayList<Integer>(Arrays.asList(-1));
            TreeNode node = stack.pop();
            if (node.val != voyage[voyageIndex])
                return new ArrayList<Integer>(Arrays.asList(-1));
            voyageIndex++;
            TreeNode left = node.left, right = node.right;
            if (left != null && right != null && right.val == voyage[voyageIndex]) {
                flipList.add(node.val);
                stack.push(left);
                stack.push(right);
            } else {
                if (right != null)
                    stack.push(right);
                if (left != null)
                    stack.push(left);
            }
        }
        if (voyageIndex != length)
            return new ArrayList<Integer>(Arrays.asList(-1));
        return flipList;
    }
}