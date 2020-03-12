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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalTraversal = new ArrayList<List<Integer>>();
        if (root == null)
            return verticalTraversal;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Struct> structQueue = new LinkedList<Struct>();
        queue.offer(root);
        Struct rootStruct = new Struct(0, 0, root.val);
        structQueue.offer(rootStruct);
        List<Struct> structList = new ArrayList<Struct>();
        structList.add(rootStruct);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Struct nodeStruct = structQueue.poll();
            int position = nodeStruct.getPosition();
            int depth = nodeStruct.getDepth();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.offer(left);
                Struct leftStruct = new Struct(position - 1, depth + 1, left.val);
                structQueue.offer(leftStruct);
                structList.add(leftStruct);
            }
            if (right != null) {
                queue.offer(right);
                Struct rightStruct = new Struct(position + 1, depth + 1, right.val);
                structQueue.offer(rightStruct);
                structList.add(rightStruct);
            }
        }
        Collections.sort(structList);
        int size = structList.size();
        int index = 0;
        int prevPosition = Integer.MAX_VALUE;
        while (index < size) {
            Struct struct = structList.get(index);
            int position = struct.getPosition();
            if (position == prevPosition) {
                int totalSize = verticalTraversal.size();
                List<Integer> previousList = verticalTraversal.remove(totalSize - 1);
                previousList.add(struct.getValue());
                verticalTraversal.add(previousList);
            } else {
                List<Integer> currentList = new ArrayList<Integer>();
                currentList.add(struct.getValue());
                verticalTraversal.add(currentList);
            }
            prevPosition = position;
            index++;
        }
        return verticalTraversal;
    }
}

class Struct implements Comparable<Struct> {
	private int position;
    private int depth;
	private int value;

	public Struct() {
		
	}

	public Struct(int position, int depth, int value) {
		this.position = position;
        this.depth = depth;
		this.value = value;
	}

	public int compareTo(Struct struct2) {
		if (this.position != struct2.position)
			return this.position - struct2.position;
		else if (this.depth != struct2.depth)
			return this.depth - struct2.depth;
        else
            return this.value - struct2.value;
	}

	public int getPosition() {
		return position;
	}

    public int getDepth() {
        return depth;
    }

    public int getValue() {
		return value;
	}
}