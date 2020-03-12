/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    TreeNode root;

    public FindElements(TreeNode root) {
        if (root != null) {
            breadthFirstSearch(root);
            this.root = root;
        }
    }

    public boolean find(int target) {
        if (root == null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int value = target;
        while (value > 0) {
            stack.push(value);
            value = (value - 1) / 2;
        }
        TreeNode node = root;
        while (node != null && !stack.isEmpty()) {
            int nextValue = stack.pop();
            if (nextValue == 2 * value + 1)
                node = node.left;
            else if (nextValue == 2 * value + 2)
                node = node.right;
            if (node != null && nextValue == target)
                return true;
            else
                value = nextValue;
        }
        return false;
    }

    private void breadthFirstSearch(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int val = node.val;
            TreeNode left = node.left, right = node.right;
            if (left != null) {
                left.val = 2 * val + 1;
                queue.offer(left);
            }
            if (right != null) {
                right.val = 2 * val + 2;
                queue.offer(right);
            }
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */