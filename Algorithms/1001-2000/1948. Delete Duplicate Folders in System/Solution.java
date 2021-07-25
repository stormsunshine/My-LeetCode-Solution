class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String node : path) {
                if (!curr.children.containsKey(node))
                    curr.children.put(node, new TrieNode());
                curr = curr.children.get(node);
            }
        }
        Map<String, Integer> freq = new HashMap<String, Integer>();
        construct(root, freq);
        List<List<String>> remaining = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        operate(root, freq, remaining, path);
        return remaining;
    }

    public void construct(TrieNode node, Map<String, Integer> freq) {
        if (node.children.isEmpty())
            return;
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();
            construct(child, freq);
            list.add(folder + "(" + child.serial.toString() + ")");
        }
        Collections.sort(list);
        for (String str : list)
            node.serial.append(str);
        String serialStr = node.serial.toString();
        freq.put(serialStr, freq.getOrDefault(serialStr, 0) + 1);
    }

    public void operate(TrieNode node, Map<String, Integer> freq, List<List<String>> remaining, List<String> path) {
        if (freq.getOrDefault(node.serial.toString(), 0) > 1)
            return;
        if (!path.isEmpty())
            remaining.add(new ArrayList<String>(path));
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();
            path.add(folder);
            operate(child, freq, remaining, path);
            path.remove(path.size() - 1);
        }
    }
}

class TrieNode {
    StringBuffer serial;
    Map<String, TrieNode> children;

    public TrieNode() {
        serial = new StringBuffer();
        children = new HashMap<String, TrieNode>();
    }
}