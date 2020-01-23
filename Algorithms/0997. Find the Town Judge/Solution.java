class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] trustArray = new int[N][2];
        for (int[] curTrust : trust) {
            int person1 = curTrust[0] - 1, person2 = curTrust[1] - 1;
            trustArray[person1][0]++;
            trustArray[person2][1]++;
        }
        for (int i = 0; i < N; i++) {
            if (trustArray[i][0] == 0 && trustArray[i][1] == N - 1)
                return i + 1;
        }
        return -1;
    }
}