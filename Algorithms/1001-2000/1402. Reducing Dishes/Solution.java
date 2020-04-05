class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int startIndex = -1;
        int length = satisfaction.length;
        for (int i = 0; i < length; i++) {
            if (satisfaction[i] >= 0) {
                startIndex = i;
                break;
            }
        }
        if (startIndex < 0)
            return 0;
        int sum = 0;
        int totalSatisfaction = 0;
        int time = 1;
        for (int i = startIndex, j = 1; i < length; i++, j++) {
            sum += satisfaction[i];
            totalSatisfaction += satisfaction[i] * j;
        }
        int maxSatisfaction = totalSatisfaction;
        for (int i = startIndex - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum < 0)
                break;
            totalSatisfaction += sum;
            maxSatisfaction = Math.max(maxSatisfaction, totalSatisfaction);
        }
        return maxSatisfaction;
    }
}