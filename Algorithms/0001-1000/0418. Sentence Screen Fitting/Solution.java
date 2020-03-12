class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int length = sentence.length;
        int[] dp = new int[length];
        int[] next = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            int index = i;
            int remainWidth = cols;
            while (remainWidth >= sentence[index].length()) {
                remainWidth -= sentence[index].length() + 1;
                index++;
                if (index == length) {
                    count++;
                    index = 0;
                }
            }
            dp[i] = count;
            next[i] = index;
        }
        int screensCount = 0;
        int index = 0;
        for (int i = 0; i < rows; i++) {
            screensCount += dp[index];
            index = next[index];
        }
        return screensCount;
    }
}