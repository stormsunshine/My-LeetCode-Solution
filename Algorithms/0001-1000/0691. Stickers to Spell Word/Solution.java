class Solution {
    public int minStickers(String[] stickers, String target) {
        int stickersCount = stickers.length, targetLength = target.length();
        int[] dp = new int[1 << targetLength];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (String sticker : stickers) {
            for (int state = 0; state < 1 << targetLength; state++) {
                if (dp[state] >= 0) {
                    int curState = state;
                    int stickerLength = sticker.length();
                    for (int i = 0; i < stickerLength; i++) {
                        char c = sticker.charAt(i);
                        for (int j = 0; j < targetLength; j++) {
                            if (c == target.charAt(j) && (curState & (1 << j)) == 0) {
                                curState |= 1 << j;
                                break;
                            }
                        }
                    }
                    if (dp[curState] == -1)
                        dp[curState] = dp[state] + 1;
                    else
                        dp[curState] = Math.min(dp[curState], dp[state] + 1);
                }
            }
        }
        return dp[(1 << targetLength) - 1];
    }
}