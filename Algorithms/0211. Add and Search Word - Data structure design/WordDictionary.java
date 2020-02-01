class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
        }
        node.wordEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.offer(root);
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TrieNode node = queue.poll();
                if (letter == '.') {
                    for (int k = 0; k < 26; k++) {
                        TrieNode nextNode = node.next[k];
                        if (nextNode != null)
                            queue.offer(nextNode);
                    }
                } else {
                    int index = letter -'a';
                    if (node.next[index] != null)
                        queue.offer(node.next[index]);
                }
            }
        }
        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            if (node.wordEnd)
                return true;
        }
        return false;
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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */