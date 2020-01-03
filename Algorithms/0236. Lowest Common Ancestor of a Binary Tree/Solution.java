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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q)
            return p;
        Map<TreeNode, String> nodePathMap = new HashMap<TreeNode, String>();
        Map<String, TreeNode> pathNodeMap = new HashMap<String, TreeNode>();
        nodePathMap.put(root, "");
        pathNodeMap.put("", root);
        boolean pFlag = false;
        boolean qFlag = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty() && (!pFlag || !qFlag)) {
            TreeNode node = queue.poll();
            if (node == p)
                pFlag = true;
            else if (node == q)
                qFlag = true;
            String path = nodePathMap.get(node);
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                queue.offer(left);
                String leftPath = path + "0";
                nodePathMap.put(left, leftPath);
                pathNodeMap.put(leftPath, left);
            }
            if (right != null) {
                queue.offer(right);
                String rightPath = path + "1";
                nodePathMap.put(right, rightPath);
                pathNodeMap.put(rightPath, right);
            }
        }
        String pPath = nodePathMap.getOrDefault(p, "");
        String qPath = nodePathMap.getOrDefault(q, "");
        String longestCommonPrefix = longestCommonPrefix(pPath, qPath);
        TreeNode lowestCommonAncestor = pathNodeMap.getOrDefault(longestCommonPrefix, null);
        return lowestCommonAncestor;
    }

    public String longestCommonPrefix(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        int length = Math.min(str1.length(), str2.length());
        for (int i = 0; i < length; i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if (c1 == c2)
                sb.append(c1);
            else
                break;
        }
        return sb.toString();
    }
}