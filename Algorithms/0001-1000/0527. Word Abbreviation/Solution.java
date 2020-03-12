class Solution {
    TrieNode root = new TrieNode();

    public List<String> wordsAbbreviation(List<String> dict) {
        addWords(dict);
        List<String> abbreviationList = new ArrayList<String>();
        int size = dict.size();
        for (int i = 0; i < size; i++) {
            String word = dict.get(i);
            int length = word.length();
            if (length <= 3)
                abbreviationList.add(word);
            else {
                char lastLetter = word.charAt(length - 1);
                int shortestPrefixLength = searchShortestPrefix(word);
                String prefix = word.substring(0, shortestPrefixLength);
                int remainLength = length - shortestPrefixLength - 1;
                String abbreviation = prefix + remainLength + lastLetter;
                if (abbreviation.length() < length)
                    abbreviationList.add(abbreviation);
                else
                    abbreviationList.add(word);
            }
        }
        return abbreviationList;
    }

    public void addWords(List<String> dict) {
        for (String word : dict) {
            TrieNode node = root;
            int length = word.length();
            char lastLetter = word.charAt(length - 1);
            for (int i = 0; i < length; i++) {
                char letter = word.charAt(i);
                int index = letter - 'a';
                if (node.next[index] == null)
                    node.next[index] = new TrieNode();
                node = node.next[index];
                String abbreviation = String.valueOf(length - i - 2) + lastLetter;
                node.addAbbreviation(abbreviation);
            }
            node.wordEnd = true;
        }
    }

    public int searchShortestPrefix(String word) {
        TrieNode node = root;
        int length = word.length();
        char lastLetter = word.charAt(length - 1);
        int lastIndex = lastLetter - 'a';
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            node = node.next[index];
            String abbreviation = String.valueOf(length - i - 2) + lastLetter;
            if (node.getAbbreviationCount(abbreviation) == 1)
                return i + 1;
        }
        return length;
    }
}

class TrieNode {
    boolean wordEnd;
    Map<String, Integer> countsMap;
    TrieNode[] next;

    public TrieNode() {
        wordEnd = false;
        countsMap = new HashMap<String, Integer>();
        next = new TrieNode[26];
    }

    public void addAbbreviation(String abbreviation) {
        int count = countsMap.getOrDefault(abbreviation, 0);
        count++;
        countsMap.put(abbreviation, count);
    }

    public int getAbbreviationCount(String abbreviation) {
        int count = countsMap.getOrDefault(abbreviation, 0);
        return count;
    }
}