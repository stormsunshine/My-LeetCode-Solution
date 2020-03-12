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
    public List<List<String>> printTree(TreeNode root) {
        if (root == null)
            return new ArrayList<List<String>>();
        List<List<int[]>> valuePositionList = new ArrayList<List<int[]>>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        Queue<Integer> positionQueue = new LinkedList<Integer>();
        positionQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            List<int[]> curRow = new ArrayList<int[]>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int position = positionQueue.poll();
                int[] valuePosition = {node.val, position};
                curRow.add(valuePosition);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    nodeQueue.offer(left);
                    positionQueue.offer(position * 2);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    positionQueue.offer(position * 2 + 1);
                }
            }
            valuePositionList.add(curRow);
        }
        List<List<String>> print = new ArrayList<List<String>>();
        int size = valuePositionList.size();
        int rowLength = (int) Math.pow(2, size) - 1;
        int difference = rowLength + 1;
        for (int i = 0; i < size; i++) {
            List<String> curRowPrint = new ArrayList<String>();
            for (int j = 0; j < rowLength; j++)
                curRowPrint.add("");
            List<int[]> rowValuePosition = valuePositionList.get(i);
            int start = difference / 2 - 1;
            for (int[] valuePosition : rowValuePosition) {
                int value = valuePosition[0], position = valuePosition[1];
                int index = start + position * difference;
                curRowPrint.set(index, String.valueOf(value));
            }
            print.add(curRowPrint);
            difference /= 2;
        }
        return print;
    }
}