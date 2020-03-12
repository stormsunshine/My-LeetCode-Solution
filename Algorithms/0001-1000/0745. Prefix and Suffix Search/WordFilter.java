class WordFilter {
    TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        int length = words.length;
        for (int weight = 0; weight < length; weight++) {
            String word = words[weight];
            StringBuffer sb = new StringBuffer("{" + word);
            insert(sb.toString(), weight);
            int wordLength = word.length();
            for (int i = wordLength - 1; i >= 0; i--) {
                sb.insert(0, word.charAt(i));
                insert(sb.toString(), weight);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String search = suffix + "{" + prefix;
        TrieNode node = root;
        int length = search.length();
        for (int i = 0; i < length; i++) {
            char letter = search.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                return -1;
            else
                node = node.next[index];
        }
        return node.weight;
    }

    private void insert(String str, int weight) {
        TrieNode node = root;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char letter = str.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
            node.weight = weight;
        }
    }
}

class TrieNode {
    TrieNode[] next;
    int weight;

    public TrieNode() {
        next = new TrieNode[27];
        weight = -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */