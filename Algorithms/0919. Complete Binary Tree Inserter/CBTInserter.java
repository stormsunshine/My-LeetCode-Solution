/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    TreeNode root;
    int numOfNodes;

    public CBTInserter(TreeNode root) {
        this.root = root;
        numOfNodes = breadthFirstSearch();
    }
    
    public int insert(int v) {
        int index = numOfNodes;
        List<Integer> path = new ArrayList<Integer>();
        while (index > 0) {
            path.add(index % 2 == 0 ? 1 : 0);
            index = (index - 1) / 2;
        }
        TreeNode temp = root;
        for (int i = path.size() - 1; i > 0; i--) {
            int move = path.get(i);
            temp = move == 0 ? temp.left : temp.right;
        }
        int parentVal = temp.val;
        int lastMove = path.get(0);
        TreeNode child = new TreeNode(v);
        if (lastMove == 0)
            temp.left = child;
        else
            temp.right = child;
        numOfNodes++;
        return parentVal;
    }
    
    public TreeNode get_root() {
        return root;
    }

    private int breadthFirstSearch() {
        int numOfNodes = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            numOfNodes++;
            TreeNode left = node.left, right = node.right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
            if (left == null || right == null) {
                numOfNodes += queue.size();
                break;
            }
        }
        return numOfNodes;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */