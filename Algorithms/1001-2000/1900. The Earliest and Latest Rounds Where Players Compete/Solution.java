class Solution {
    Set<String> set = new HashSet<String>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        firstPlayer--;
        secondPlayer--;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{n, firstPlayer, secondPlayer});
        int steps = 0;
        int minSteps = Integer.MAX_VALUE, maxSteps = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] state = queue.poll();
                int curN = state[0], curFirst = state[1], curSecond = state[2];
                if (curFirst + curSecond == curN - 1) {
                    minSteps = Math.min(minSteps, steps);
                    maxSteps = Math.max(maxSteps, steps);
                } else if (curN > 2) {
                    List<int[]> nextStates = getNextStates(state);
                    for (int[] nextState : nextStates) {
                        String stateStr = Arrays.toString(nextState);
                        if (set.add(stateStr))
                            queue.offer(nextState);
                    }
                }
            }
        }
        return new int[]{minSteps, maxSteps};
    }

    public List<int[]> getNextStates(int[] state) {
        List<int[]> nextStates = new ArrayList<int[]>();
        int n = state[0], firstPlayer = state[1], secondPlayer = state[2];
        int[] nextState = new int[n];
        nextState[firstPlayer] = 2;
        nextState[secondPlayer] = 2;
        if (n - 1 - firstPlayer != firstPlayer)
            nextState[n - 1 - firstPlayer] = -2;
        if (n - 1 - secondPlayer != secondPlayer)
            nextState[n - 1 - secondPlayer] = -2;
        if (n % 2 == 1 && nextState[n / 2] == 0)
            nextState[n / 2] = 1;
        backtrack(nextStates, nextState, 0);
        return nextStates;
    }

    public void backtrack(List<int[]> nextStates, int[] nextState, int index) {
        int n = nextState.length;
        if (index == n / 2) {
            int[] newState = new int[3];
            int nextN = (n + 1) / 2;
            newState[0] = nextN;
            int stateIndex = 1, playerIndex = 0;
            for (int i = 0; i < n; i++) {
                if (nextState[i] == 2)
                    newState[stateIndex++] = playerIndex;
                if (nextState[i] > 0)
                    playerIndex++;
            }
            nextStates.add(newState);
        } else {
            if (nextState[index] == 0) {
                nextState[index] = 1;
                nextState[n - 1 - index] = -1;
                backtrack(nextStates, nextState, index + 1);
                nextState[index] = -1;
                nextState[n - 1 - index] = 1;
                backtrack(nextStates, nextState, index + 1);
                nextState[index] = 0;
                nextState[n - 1 - index] = 0;
            } else
                backtrack(nextStates, nextState, index + 1);
        }
    }
}