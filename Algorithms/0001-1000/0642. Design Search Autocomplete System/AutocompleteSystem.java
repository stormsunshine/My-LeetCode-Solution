class AutocompleteSystem {
    TrieNode root;
    StringBuffer inputStr;
    TrieNode searchNode;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        int counts = sentences.length;
        for (int i = 0; i < counts; i++) {
            String sentence = sentences[i];
            int hotDegree = times[i];
            insert(sentence, hotDegree);
        }
        inputStr = new StringBuffer();
        searchNode = root;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            String completeSentence = inputStr.toString();
            insert(completeSentence, 1);
            inputStr = new StringBuffer();
            searchNode = root;
            return new ArrayList<String>();
        } else {
            inputStr.append(c);
            if (searchNode == null)
                return new ArrayList<String>();
            int index = c == ' ' ? 26 : c - 'a';
            searchNode = searchNode.next[index];
            if (searchNode == null)
                return new ArrayList<String>();
            PriorityQueue<TrieNode> priorityQueue = new PriorityQueue<TrieNode>();
            Queue<TrieNode> queue = new LinkedList<TrieNode>();
            queue.offer(searchNode);
            while (!queue.isEmpty()) {
                TrieNode node = queue.poll();
                if (node.sentence.length() > 0) {
                    priorityQueue.offer(node);
                    if (priorityQueue.size() > 3)
                        priorityQueue.poll();
                }
                TrieNode[] next = node.next;
                for (int i = 0; i <= 26; i++) {
                    TrieNode nextNode = next[i];
                    if (nextNode != null)
                        queue.offer(nextNode);
                }
            }
            List<String> hotSentences = new ArrayList<String>();
            while (!priorityQueue.isEmpty())
                hotSentences.add(priorityQueue.poll().sentence);
            Collections.reverse(hotSentences);
            return hotSentences;
        }
    }

    private void insert(String sentence, int hotDegree) {
        TrieNode node = root;
        int length = sentence.length();
        for (int i = 0; i < length; i++) {
            char c = sentence.charAt(i);
            int index = c == ' ' ? 26 : c - 'a';
            if (node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
        }
        node.sentence = sentence;
        node.hotDegree += hotDegree;
    }
}

class TrieNode implements Comparable<TrieNode> {
    TrieNode[] next;
    String sentence;
    int hotDegree;

    public TrieNode() {
        next = new TrieNode[27];
        sentence = "";
        hotDegree = 0;
    }

    public int compareTo(TrieNode trieNode2) {
        if (this.hotDegree != trieNode2.hotDegree)
            return this.hotDegree - trieNode2.hotDegree;
        else
            return trieNode2.sentence.compareTo(this.sentence);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */