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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> verticalOrder = new ArrayList<List<Integer>>();
        if (root == null)
            return verticalOrder;
        List<Element> elementsList = new ArrayList<Element>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<int[]> positionQueue = new LinkedList<int[]>();
		Queue<String> pathQueue = new LinkedList<String>();
		queue.offer(root);
		positionQueue.offer(new int[]{0, 0});
		pathQueue.offer("");
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int[] position = positionQueue.poll();
			String path = pathQueue.poll();
			Element element = new Element(node.val, position[0], position[1], path);
			elementsList.add(element);
			TreeNode left = node.left;
			if (left != null) {
				queue.offer(left);
				positionQueue.offer(new int[]{position[0] - 1, position[1] + 1});
				pathQueue.offer(path + "0");
			}
			TreeNode right = node.right;
			if (right != null) {
				queue.offer(right);
				positionQueue.offer(new int[]{position[0] + 1, position[1] + 1});
				pathQueue.offer(path + "1");
			}
		}
		Collections.sort(elementsList);
		int size = elementsList.size();
		int minColumn = elementsList.get(0).column;
		int maxColumn = elementsList.get(size - 1).column;
		int difference = -minColumn;
		int columns = maxColumn - minColumn + 1;
		for (int i = 0; i < columns; i++)
			verticalOrder.add(new ArrayList<Integer>());
		for (int i = 0; i < size; i++) {
			Element element = elementsList.get(i);
			int num = element.num;
			int index = element.column + difference;
			verticalOrder.get(index).add(num);
		}
        return verticalOrder;
    }
}

class Element implements Comparable<Element> {
	int num;
	int column;
	int level;
	String path;

	Element() {
		
	}

	Element(int num, int column, int level, String path) {
		this.num = num;
		this.column = column;
		this.level = level;
		this.path = path;
	}

	public int compareTo(Element element2) {
		if (column != element2.column)
			return column - element2.column;
		else if (level != element2.level)
			return level - element2.level;
		else
			return path.compareTo(element2.path);
	}
}