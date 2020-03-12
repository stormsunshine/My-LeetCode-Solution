class StreamChecker {
    TrieNode root;
    StringBuffer queryStr;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        for (String word : words)
            insert(word);
        queryStr = new StringBuffer();
    }
    
    public boolean query(char letter) {
        queryStr.append(letter);
        return query(queryStr.toString());
    }

    private void insert(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = length - 1; i >= 0; i--) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.prev[index] == null)
                node.prev[index] = new TrieNode();
            node = node.prev[index];
        }
        node.wordStart = true;
    }

    private boolean query(String str) {
        TrieNode node = root;
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            char letter = str.charAt(i);
            int index = letter - 'a';
            if (node.prev[index] == null)
                return false;
            else {
                node = node.prev[index];
                if (node.wordStart)
                    return true;
            }
        }
        return node.wordStart;
    }
}

class TrieNode {
    boolean wordStart;
    TrieNode[] prev;

    public TrieNode() {
        wordStart = false;
        prev = new TrieNode[26];
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */