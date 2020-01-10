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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> closestKValues = new ArrayList<Integer>();
        int size = 0;
        List<Integer> inorderTraversal = inorderTraversal(root);
        int length = inorderTraversal.size();
        int index = binarySearch(inorderTraversal, target);
        int index1 = -1, index2 = -1;
        if (index >= 0) {
            closestKValues.add(inorderTraversal.get(index));
            size++;
            index1 = index - 1;
            index2 = index + 1;
        } else {
            index = -index - 1;
            index1 = index - 1;
            index2 = index;
        }
        while (size < k && index1 >= 0 && index2 < length) {
            int num1 = inorderTraversal.get(index1), num2 = inorderTraversal.get(index2);
            if (target - num1 <= num2 - target) {
                closestKValues.add(num1);
                index1--;
            } else {
                closestKValues.add(num2);
                index2++;
            }
            size++;
        }
        while (size < k && index1 >= 0) {
            int num1 = inorderTraversal.get(index1);
            closestKValues.add(num1);
            index1--;
            size++;
        }
        while (size < k && index2 < length) {
            int num2 = inorderTraversal.get(index2);
            closestKValues.add(num2);
            index2++;
            size++;
        }
        return closestKValues;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
    }

    public int binarySearch(List<Integer> list, double target) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = list.get(mid);
            if (num == target)
                return mid;
            else if (num > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}