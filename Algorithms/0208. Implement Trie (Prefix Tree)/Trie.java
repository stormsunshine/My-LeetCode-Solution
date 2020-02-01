class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                return false;
            else
                node = node.next[index];
        }
        return node.wordEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int length = prefix.length();
        for (int i = 0; i < length; i++) {
            char letter = prefix.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                return false;
            else
                node = node.next[index];
        }
        return true;
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
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */