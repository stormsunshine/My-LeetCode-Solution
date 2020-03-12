class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int jobs = difficulty.length;
        int[][] difficultyProfit = new int[jobs][2];
        for (int i = 0; i < jobs; i++) {
            difficultyProfit[i][0] = difficulty[i];
            difficultyProfit[i][1] = profit[i];
        }
        Arrays.sort(difficultyProfit, new Comparator<int[]>() {
            public int compare(int[] difficultyProfit1, int[] difficultyProfit2) {
                if (difficultyProfit1[0] != difficultyProfit2[0])
                    return difficultyProfit1[0] - difficultyProfit2[0];
                else
                    return difficultyProfit2[1] - difficultyProfit1[1];
            }
        });
        for (int i = 1; i < jobs; i++)
            difficultyProfit[i][1] = Math.max(difficultyProfit[i - 1][1], difficultyProfit[i][1]);
        int totalProfit = 0;
        for (int ability : worker) {
            int maxProfit = binarySearch(difficultyProfit, ability);
            totalProfit += maxProfit;
        }
        return totalProfit;
    }

    public int binarySearch(int[][] difficultyProfit, int ability) {
        int low = 0, high = difficultyProfit.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int difficulty = difficultyProfit[mid][0];
            if (difficulty == ability) {
                index = mid;
                break;
            } else if (difficulty > ability)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (index < 0)
            index = low - 1;
        if (index < 0)
            return 0;
        else
            return difficultyProfit[index][1];
    }
}