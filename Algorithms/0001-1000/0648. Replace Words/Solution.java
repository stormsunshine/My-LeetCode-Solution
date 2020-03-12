class Solution {
    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dict, String sentence) {
        createTrie(dict);
        String[] array = sentence.split(" ");
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int prefixLength = searchPrefix(array[i]);
            if (prefixLength > 0)
                array[i] = array[i].substring(0, prefixLength);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++)
            sb.append(array[i] + " ");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void createTrie(List<String> dict) {
        for (String prefix : dict) {
            TrieNode node = root;
            int length = prefix.length();
            for (int i = 0; i < length; i++) {
                char letter = prefix.charAt(i);
                int index = letter - 'a';
                if (node.next[index] == null)
                    node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.isEnd = true;
        }
    }

    public int searchPrefix(String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.isEnd)
                return i;
            else if (node.next[index] == null)
                return 0;
            else
                node = node.next[index];
        }
        return node.isEnd ? length : 0;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] next;

    public TrieNode() {
        isEnd = false;
        next = new TrieNode[26];
    }
}