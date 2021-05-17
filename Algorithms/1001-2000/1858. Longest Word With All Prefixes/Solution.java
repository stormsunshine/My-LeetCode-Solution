class Solution {
    String longestWord = "";

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char letter = word.charAt(i);
                int index = letter - 'a';
                if (node.children[index] == null)
                    node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.wordEnd = true;
        }
        depthFirstSearch(root, new StringBuffer());
        return longestWord;
    }

    public void depthFirstSearch(TrieNode node, StringBuffer sb) {
        if (node.wordEnd && sb.length() > longestWord.length())
            longestWord = sb.toString();
        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child != null && child.wordEnd) {
                sb.append((char) ('a' + i));
                depthFirstSearch(child, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

class TrieNode {
    boolean wordEnd;
    TrieNode[] children;

    public TrieNode() {
        wordEnd = false;
        children = new TrieNode[26];
    }
}