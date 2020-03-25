class Solution {
    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> concatenateWords = new ArrayList<String>();
        if (words == null || words.length == 0)
            return concatenateWords;
        for (String word : words) {
            if (word.length() > 0)
                insert(word);
        }
        for (String word: words) {
            if (depthFirstSearch(word, root, 0, 0))
                concatenateWords.add(word);
        }
        return concatenateWords;
    }

    public void insert(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
        }
        node.wordEnd = true;
    }

    public boolean depthFirstSearch(String word, TrieNode node, int count, int start) {
        int length = word.length();
        for (int i = start; i < length; i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null)
                return false;
            node = node.next[index];
            if (node.wordEnd && depthFirstSearch(word, root, count + 1, i + 1))
                return true;
        }
        return count > 0 && node.wordEnd;
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