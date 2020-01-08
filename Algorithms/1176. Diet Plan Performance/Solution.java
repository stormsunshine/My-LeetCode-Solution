class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += calories[i];
        if (sum > upper)
            points++;
        else if (sum < lower)
            points--;
        int length = calories.length;
        for (int i = k; i < length; i++) {
            sum += calories[i];
            sum -= calories[i - k];
            if (sum > upper)
                points++;
            else if (sum < lower)
                points--;
        }
        return points;
    }
}