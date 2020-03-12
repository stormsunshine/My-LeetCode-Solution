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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (root.val == key) {
            TreeNode dummyRoot = new TreeNode(0);
            dummyRoot.left = root;
            if (root.right != null) {
                TreeNode successor = root.right;
                if (successor.left == null) {
                    successor.left = root.left;
                    dummyRoot.left = successor;
                } else {
                    TreeNode parent = successor, child = successor.left;
                    while (child.left != null) {
                        child = child.left;
                        parent = parent.left;
                    }
                    root.val = child.val;
                    parent.left = child.right;
                }
            } else
                dummyRoot.left = root.left;
            return dummyRoot.left;
        } else {
            TreeNode parent = root;
            TreeNode child = root.val > key ? root.left : root.right;
            while (child != null && child.val != key) {
                parent = child;
                child = child.val > key ? child.left : child.right;
            }
            if (child != null) {
                boolean isLeftChild = parent.left == child;
                if (child.left == null && child.right == null) {
                    if (isLeftChild)
                        parent.left = null;
                    else
                        parent.right = null;
                } else if (child.left == null) {
                    if (isLeftChild)
                        parent.left = child.right;
                    else
                        parent.right = child.right;
                } else if (child.right == null) {
                    if (isLeftChild)
                        parent.left = child.left;
                    else
                        parent.right = child.left;
                } else {
                    TreeNode temp1 = child.right;
                    if (temp1.left == null) {
                        child.val = temp1.val;
                        child.right = temp1.right;
                    } else {
                        TreeNode temp2 = temp1.left;
                        while (temp2.left != null) {
                            temp2 = temp2.left;
                            temp1 = temp1.left;
                        }
                        child.val = temp2.val;
                        temp1.left = temp2.right;
                    }
                }
            }
            return root;
        }
    }
}