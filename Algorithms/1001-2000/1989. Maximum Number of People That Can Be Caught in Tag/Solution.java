class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int length = team.length;
        int zero = 0, one = 0;
        while (zero < length && team[zero] != 0)
            zero++;
        while (one < length && team[one] != 1)
            one++;
        int count = 0;
        while (zero < length && one < length) {
            while (one - zero > dist)
                zero++;
            int maxIndex = Math.min(one + dist, length - 1);
            while (zero <= maxIndex && team[zero] != 0)
                zero++;
            if (zero <= maxIndex) {
                count++;
                zero++;
            }
            one++;
            while (one < length && team[one] != 1)
                one++;
        }
        return count;
    }
}