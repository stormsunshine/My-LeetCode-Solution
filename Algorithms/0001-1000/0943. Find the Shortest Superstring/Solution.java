class Solution {
    public String shortestSuperstring(String[] A) {
        int length = A.length;
        int[][] overlaps = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    int strLength = Math.min(A[i].length(), A[j].length());
                    for (int k = strLength; k >= 0; k--) {
                        if (A[i].endsWith(A[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }
        int states = 1 << length;
        int[][] dp = new int[states][length];
        int[][] parents = new int[states][length];
        for (int mask = 0; mask < states; mask++) {
            Arrays.fill(parents[mask], -1);
            for (int i = 0; i < length; i++) {
                if (((mask >> i) & 1) > 0) {
                    int prevMask = mask ^ (1 << i);
                    if (prevMask == 0)
                        continue;
                    for (int j = 0; j < length; j++) {
                        if (((prevMask >> j) & 1) > 0) {
                            int value = dp[prevMask][j] + overlaps[j][i];
                            if (value > dp[mask][i]) {
                                dp[mask][i] = value;
                                parents[mask][i] = j;
                            }
                        }
                    }
                }
            }
        }
        int[] permutation = new int[length];
        boolean[] visited = new boolean[length];
        int permIndex = 0;
        int mask = states - 1;
        int strIndex = 0;
        for (int i = 0; i < length; i++) {
            if (dp[states - 1][i] > dp[states - 1][strIndex])
                strIndex = i;
        }
        while (strIndex != -1) {
            permutation[permIndex++] = strIndex;
            visited[strIndex] = true;
            int parentIndex = parents[mask][strIndex];
            mask ^= 1 << strIndex;
            strIndex = parentIndex;
        }
        for (int i = permIndex / 2 - 1; i >= 0; i--) {
            int temp = permutation[i];
            permutation[i] = permutation[permIndex - 1 - i];
            permutation[permIndex - 1 - i] = temp;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i])
                permutation[permIndex++] = i;
        }
        StringBuffer sb = new StringBuffer(A[permutation[0]]);
        for (int i = 1; i < length; i++) {
            int overlap = overlaps[permutation[i - 1]][permutation[i]];
            sb.append(A[permutation[i]].substring(overlap));
        }
        return sb.toString();
    }
}