class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int stampLength = stamp.length(), targetLength = target.length();
        boolean[] finished = new boolean[targetLength];
        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        List<Set<Integer>> matchList = new ArrayList<Set<Integer>>();
        List<Set<Integer>> notMatchList = new ArrayList<Set<Integer>>();
        int maxIndex = targetLength - stampLength;
        for (int i = 0; i <= maxIndex; i++) {
            Set<Integer> matchSet = new HashSet<Integer>();
            Set<Integer> notMatchSet = new HashSet<Integer>();
            for (int j = 0; j < stampLength; j++) {
                if (stamp.charAt(j) == target.charAt(i + j))
                    matchSet.add(i + j);
                else
                    notMatchSet.add(i + j);
            }
            matchList.add(matchSet);
            notMatchList.add(notMatchSet);
            if (notMatchSet.isEmpty()) {
                stack.push(i);
                for (int j = 0; j < stampLength; j++) {
                    int index = i + j;
                    if (!finished[index]) {
                        finished[index] = true;
                        queue.offer(index);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int startIndex = Math.max(0, index + 1 - stampLength);
            int endIndex = Math.min(maxIndex, index);
            for (int i = startIndex; i <= endIndex; i++) {
                Set<Integer> notMatchSet = notMatchList.get(i);
                if (notMatchSet.remove(index)) {
                    if (notMatchSet.isEmpty()) {
                        stack.push(i);
                        Set<Integer> matchSet = matchList.get(i);
                        for (int j : matchSet) {
                            if (!finished[j]) {
                                finished[j] = true;
                                queue.offer(j);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < targetLength; i++) {
            if (!finished[i])
                return new int[0];
        }
        int stampSequenceLength = stack.size();
        int[] stampSequence = new int[stampSequenceLength];
        for (int i = 0; i < stampSequenceLength; i++)
            stampSequence[i] = stack.pop();
        return stampSequence;
    }
}