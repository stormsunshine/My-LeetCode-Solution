class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
            node.count++;
        }
        node.endCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                return 0;
            else
                node = node.next[index];
        }
        return node.endCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        int length = prefix.length();
        for (int i = 0; i < length; i++) {
            char letter = prefix.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                return 0;
            else
                node = node.next[index];
        }
        return node.count;
    }

    public void erase(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                return;
            node = node.next[index];
            node.count--;
        }
        node.endCount--;
    }
}

class TrieNode {
    int count;
    int endCount;
    TrieNode[] next;

    public TrieNode() {
        count = 0;
        endCount = 0;
        next = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */