class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            heads[i] = new ArrayList<Node>();
        for (String word : words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        char[] array = S.toCharArray();
        for (char c : array) {
            ArrayList<Node> oldBucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();
            for (Node node : oldBucket) {
                node.index++;
                int wordLength = node.word.length();
                if (node.index == wordLength)
                    count++;
                else
                    heads[node.word.charAt(node.index) - 'a'].add(node);
            }
            oldBucket.clear();
        }
        return count;
    }
}

class Node {
    String word;
    int index;

    public Node(String word, int index) {
        this.word = word;
        this.index = index;
    }
}