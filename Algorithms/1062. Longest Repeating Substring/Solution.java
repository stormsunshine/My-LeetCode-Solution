class Solution {
    public int longestRepeatingSubstring(String S) {
        int maxLength = 0;
        TrieNode root = new TrieNode();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            TrieNode node = root;
            for (int j = i; j < length; j++) {
                int index = S.charAt(j) - 'a';
                if (node.next[index] != null)
                    maxLength = Math.max(maxLength, j - i + 1);
                else
                    node.next[index] = new TrieNode();
                node = node.next[index];
            }
        }
        return maxLength;
    }
}


class TrieNode {
    TrieNode[] next;

    public TrieNode() {
        next = new TrieNode[26];
    }
}