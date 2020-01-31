/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                sb.append("null,");
            else {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        if (sb.charAt(sb.length() - 1) == ',')
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] valuesArray = data.split(",");
        int length = valuesArray.length;
        TreeNode[] nodesArray = new TreeNode[length];
        nodesArray[0] = new TreeNode(Integer.parseInt(valuesArray[0]));
        int parentIndex = 0;
        boolean leftAssigned = false;
        for (int i = 1; i < length; i++) {
            String valueStr = valuesArray[i];
            if (!valueStr.equals("null")) {
                int value = Integer.parseInt(valueStr);
                nodesArray[i] = new TreeNode(value);
            }
            if (!leftAssigned) {
                nodesArray[parentIndex].left = nodesArray[i];
                leftAssigned = true;
            } else {
                nodesArray[parentIndex].right = nodesArray[i];
                parentIndex++;
                leftAssigned = false;
            }
            while (parentIndex < length && nodesArray[parentIndex] == null)
                parentIndex++;
        }
        return nodesArray[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));