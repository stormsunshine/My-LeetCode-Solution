class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int leftCount = 0;
        int length = s.length();
        int index = 0;
        while (index < length) {
            char c = s.charAt(index);
            if (c == '(') {
                leftCount++;
                index++;
            } else {
                if (leftCount == 0)
                    insertions++;
                else
                    leftCount--;
                if (index == length - 1 || s.charAt(index + 1) != ')') {
                    insertions++;
                    index++;
                } else
                    index += 2;
            }
        }
        insertions += leftCount * 2;
        return insertions;
    }
}