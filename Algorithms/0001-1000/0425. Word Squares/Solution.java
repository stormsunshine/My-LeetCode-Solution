class Solution {
    public List<List<String>> wordSquares(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words)
            insert(root, word);
        List<List<String>> squares = new ArrayList<List<String>>();
        int length = words[0].length();
        String[] finished = new String[length];
        char[][] board = new char[length][length];
        search(root, root, board, 0, 0, length, finished, squares);
        return squares;
    }

    public void insert(TrieNode root, String word) {
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.next[index] == null)
                node.next[index] = new TrieNode();
            node = node.next[index];
        }
        node.word = word;
    }
    
    public void search(TrieNode current, TrieNode root, char[][] board, int row, int column, int length, String[] finished, List<List<String>> squares) {
        if (row == length)
            squares.add(new ArrayList<String>(Arrays.asList(finished)));
        else if (column == length) {
            finished[row] = current.word;
            search(root, root, board, row + 1, 0, length, finished, squares);
        } else if (column < row) {
            char letter = board[row][column];
            TrieNode nextNode = current.next[letter - 'a'];
            if (nextNode != null)
                search(nextNode, root, board, row, column + 1, length, finished, squares);
        } else {
            for (char c = 'a'; c <= 'z'; c++) {
                int index = c - 'a';
                if (current.next[index] != null) {
                    if (row == 0 && root.next[index] == null)
                        continue;
                    board[row][column] = c;
                    board[column][row] = c;
                    search(current.next[index], root, board, row, column + 1, length, finished, squares);
                }
            }
        }
    }
}

class TrieNode {
    TrieNode[] next;
    String word = null;

    public TrieNode() {
        next = new TrieNode[26];
    }
}