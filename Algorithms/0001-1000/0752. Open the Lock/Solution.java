class Solution {
    public int openLock(String[] deadends, String target) {
        if (deadends == null || target == null)
            return -1;
        if (target.equals("0000"))
            return 0;
        final int WHEELS = 4;
        Set<String> deadendsSet = new HashSet<String>();
        for (String deadend : deadends)
            deadendsSet.add(deadend);
        if (deadendsSet.contains("0000"))
            return -1;
        int turns = 0;
        Set<String> visitedSet = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            turns++;
            Set<String> nextStatesSet = new HashSet<String>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                visitedSet.add(state);
                char[] array = state.toCharArray();
                for (int j = 0; j < WHEELS; j++) {
                    array[j] = array[j] == '0' ? '9' : (char) (array[j] - 1);
                    String nextState1 = new String(array);
                    array[j] = array[j] == '9' ? '0' : (char) (array[j] + 1);
                    array[j] = array[j] == '9' ? '0' : (char) (array[j] + 1);
                    String nextState2 = new String(array);
                    array[j] = array[j] == '0' ? '9' : (char) (array[j] - 1);
                    if (nextState1.equals(target) || nextState2.equals(target))
                        return turns;
                    if (!visitedSet.contains(nextState1) && !deadendsSet.contains(nextState1))
                        nextStatesSet.add(nextState1);
                    if (!visitedSet.contains(nextState2) && !deadendsSet.contains(nextState2))
                        nextStatesSet.add(nextState2);
                }
            }
            for (String nextState : nextStatesSet)
                queue.offer(nextState);
        }
        return -1;
    }
}