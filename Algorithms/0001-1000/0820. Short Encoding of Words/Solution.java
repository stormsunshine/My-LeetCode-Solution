class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            int length = word.length();
            for (int i = length - 1; i >= 0; i--) {
                char letter = word.charAt(i);
                int index = letter - 'a';
                if (node.next[index] == null)
                    node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.wordEnd = true;
        }
        int totalLength = 0;
        int depth = 0;
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TrieNode node = queue.poll();
                TrieNode[] next = node.next;
                int childrenCount = 0;
                for (TrieNode child : next) {
                    if (child != null) {
                        queue.offer(child);
                        childrenCount++;
                    }
                }
                if (childrenCount == 0)
                    totalLength += depth + 1;
            }
            depth++;
        }
        return totalLength;
    }
}

class TrieNode {
    boolean wordEnd;
    TrieNode[] next;

    public TrieNode() {
        wordEnd = false;
        next = new TrieNode[26];
    }
}