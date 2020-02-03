class Solution {
    int count = 0;

    public int countArrangement(int N) {
        if (N == 0)
            return 0;
        boolean[] used = new boolean[N + 1];
        backtrack(N, 1, used);
        return count;
    }

    public void backtrack(int N, int position, boolean[] used) {
        if (position > N)
            count++;
        else {
            for (int i = 1; i <= N; i++) {
                if (!used[i] && (i % position == 0 || position % i == 0)) {
                    used[i] = true;
                    backtrack(N, position + 1, used);
                    used[i] = false;
                }
            }
        }
    }
}