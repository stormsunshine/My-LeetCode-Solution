class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int low = 0, high = tokens.length - 1;
        int points = 0, power = P;
        int maxPoints = 0;
        while (low <= high) {
            if (tokens[low] > power && points == 0)
                break;
            if (tokens[low] <= power) {
                power -= tokens[low];
                low++;
                points++;
            } else {
                power += tokens[high];
                high--;
                points--;
            }
            maxPoints = Math.max(maxPoints, points);
        }
        return maxPoints;
    }
}