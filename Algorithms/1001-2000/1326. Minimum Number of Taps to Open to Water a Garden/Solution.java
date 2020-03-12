class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] minMaxArray = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            int range = ranges[i];
            int min = Math.max(i - range, 0);
            int max = Math.min(i + range - 1, n - 1);
            minMaxArray[i][0] = min;
            minMaxArray[i][1] = max;
        }
        boolean[] covered = new boolean[n];
        int coverCount = 0;
        int openCount = 0;
        boolean[] used = new boolean[n + 1];
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                if (covered[i])
                    continue;
                int maxLengthIndex = -1;
                int maxLength = 0;
                for (int j = 0; j <= n; j++) {
                    if (used[j])
                        continue;
                    int[] array = minMaxArray[j];
                    int min = array[0], max = array[1];
                    if (min <= i && max >= i) {
                        int length = 0;
                        for (int k = min; k <= max; k++) {
                            if (!covered[k])
                                length++;
                        }
                        if (length > maxLength) {
                            maxLengthIndex = j;
                            maxLength = length;
                        }
                    }
                }
                if (maxLengthIndex >= 0) {
                    used[maxLengthIndex] = true;
                    int min = minMaxArray[maxLengthIndex][0], max = minMaxArray[maxLengthIndex][1];
                    for (int j = min; j <= max; j++) {
                    	if (!covered[j]) {
                    	    covered[j] = true;
                            coverCount++;
                    	}
                    }
                    flag = true;
                    openCount++;
                }
            }
        }
        return coverCount == n ? openCount : -1;
    }
}