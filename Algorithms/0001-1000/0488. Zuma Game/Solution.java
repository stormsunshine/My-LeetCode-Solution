class Solution {
    public int findMinStep(String board, String hand) {
        Map<Character, Integer> colorIdMap = new HashMap<Character, Integer>();
        Map<Integer, Character> idColorMap = new HashMap<Integer, Character>();
        String colors = "RYBGW";
        for (int id = 0; id < 5; id++) {
            char color = colors.charAt(id);
            colorIdMap.put(color, id);
            idColorMap.put(id, color);
        }
        Map<String, Integer> memo = new HashMap<String, Integer>();
        int[] hands = new int[5];
        int handLength = hand.length();
        for (int i = 0; i < handLength; i++) {
            char c = hand.charAt(i);
            int index = colorIdMap.get(c);
            hands[index]++;
        }
        return backtrack(board, hands, idColorMap, memo);
    }

    public int backtrack(String board, int[] hands, Map<Integer, Character> idColorMap, Map<String, Integer> memo) {
        board = removeSame(board);
        if (board.length() == 0)
            return 0;
        String key = board + Arrays.toString(hands);
        if (memo.containsKey(key))
            return memo.get(key);
        int insertions = -1;
        int handsLength = hands.length, boardLength = board.length();
        for (int i = 0; i < handsLength; i++) {
            if (hands[i] != 0) {
                char color = idColorMap.get(i);
                hands[i]--;
                for (int j = 0; j <= boardLength; j++) {
                    String newBoard = board.substring(0, j) + color + board.substring(j);
                    int nextInsertions = backtrack(newBoard, hands, idColorMap, memo);
                    if (nextInsertions != -1) {
                        if (insertions == -1)
                            insertions = nextInsertions + 1;
                        else
                            insertions = Math.min(insertions, nextInsertions + 1);
                    }
                }
                hands[i]++;
            }
        }
        memo.put(key, insertions);
        return insertions;
    }

    public String removeSame(String board) {
        StringBuffer sb = new StringBuffer(board);
        int length = sb.length();
        boolean flag = true;
        while (flag) {
            int left = length - 2, right = length - 1;
            while (left >= 0) {
                if (sb.charAt(left) == sb.charAt(right))
                    left--;
                else {
                    if (right - left >= 3) {
                        sb.delete(left + 1, right + 1);
                        right = left;
                        left--;
                    } else
                        right = left;
                }
            }
            if (right - left >= 3)
                sb.delete(left + 1, right + 1);
            int curLength = sb.length();
            if (curLength == length)
                flag = false;
            else
                length = curLength;
        }
        return sb.toString();
    }
}