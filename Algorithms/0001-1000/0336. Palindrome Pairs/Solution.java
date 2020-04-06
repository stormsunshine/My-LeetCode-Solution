class Solution {
    TrieNode root;

    public List<List<Integer>> palindromePairs(String[] words) {
        root = new TrieNode();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            String reverse = new StringBuffer(word).reverse().toString();
            TrieNode curr = root;
            if (isPalindrome(reverse))
                curr.suffixList.add(i);
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = reverse.charAt(j);
                int index = c - 'a';
                if (curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
                if (isPalindrome(reverse.substring(j + 1)))
                    curr.suffixList.add(i);
            }
            curr.wordList.add(i);
        }
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        for (int i = 0; i < length; i++) {
            String word = words[i];
            TrieNode curr = root;
            int wordLength = word.length();
            int j = 0;
            while (j < wordLength) {
                if (isPalindrome(word.substring(j))) {
                    List<Integer> wordList = curr.wordList;
                    for (int k : wordList) {
                        if (k != i)
                            pairs.add(Arrays.asList(i, k));
                    }
                }
                char c = word.charAt(j);
                int index = c - 'a';
                if (curr.children[index] == null)
                    break;
                else
                    curr = curr.children[index];
                j++;
            }
            if (j == wordLength) {
                List<Integer> suffixList = curr.suffixList;
                for (int k : suffixList) {
                    if (k != i)
                        pairs.add(Arrays.asList(i, k));
                }
            }
        }
        return pairs;
    }

    public boolean isPalindrome(String word) {
        int low = 0, high = word.length() - 1;
        while (low < high) {
            if (word.charAt(low) != word.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    List<Integer> wordList;
    List<Integer> suffixList;

    public TrieNode() {
        children = new TrieNode[26];
        wordList = new ArrayList<Integer>();
        suffixList = new ArrayList<Integer>();
    }
}