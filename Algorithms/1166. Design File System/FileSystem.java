class FileSystem {
    List<TreeNode> roots;

    public FileSystem() {
        roots = new ArrayList<TreeNode>();
    }

    public boolean createPath(String path, int value) {
        if (path.charAt(0) == '/')
            path = path.substring(1);
        String[] array = path.split("/");
        int length = array.length;
        TreeNode tempNode = null;
        List<TreeNode> tempList = roots;
        for (int i = 0; i < length; i++) {
            String subPath = array[i];
            int index = binarySearch(tempList, subPath);
            if (index < 0 && i < length - 1 || index >= 0 && i == length - 1)
                return false;
            if (index >= 0) {
                tempNode = tempList.get(index);
                tempList = tempNode.getChildren();
            } else {
                TreeNode newNode = new TreeNode(subPath, value);
                if (tempNode == null) {
                    roots.add(newNode);
                    Collections.sort(roots);
                } else
                    tempNode.addChild(newNode);
            }
        }
        return true;
    }

    public int get(String path) {
        if (path.charAt(0) == '/')
            path = path.substring(1);
        String[] array = path.split("/");
        int length = array.length;
        TreeNode tempNode = null;
        List<TreeNode> tempList = roots;
        for (int i = 0; i < length; i++) {
            String subPath = array[i];
            int index = binarySearch(tempList, subPath);
            if (index < 0)
                return -1;
            else {
                tempNode = tempList.get(index);
                tempList = tempNode.getChildren();
            }
        }
        return tempNode.getValue();
    }

    public int binarySearch(List<TreeNode> list, String subPath) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            TreeNode temp = list.get(mid);
            String tempPath = temp.getPath();
            if (tempPath.compareTo(subPath) == 0)
                return mid;
            else if (tempPath.compareTo(subPath) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -low - 1;
    }
}

class TreeNode implements Comparable<TreeNode> {
    private String path;
    private int value;
    private List<TreeNode> children;

    public TreeNode() {
        children = new ArrayList<TreeNode>();
    }

    public TreeNode(String path, int value) {
        this.path = path;
        this.value = value;
        children = new ArrayList<TreeNode>();
    }

    public String getPath() {
        return path;
    }

    public int getValue() {
        return value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
        Collections.sort(children);
    }

	public int compareTo(TreeNode node) {
		return this.path.compareTo(node.path);
	}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */