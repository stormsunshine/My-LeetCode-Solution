class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        int length = arr.length;
        if (arr[0] == arr[length - 1])
            return 1;
        else if (arr[0] == arr[length - 2])
            return 2;
        Map<Integer, List<Integer>> valueIndicesMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < length; i++) {
            int num = arr[i];
            List<Integer> indices = valueIndicesMap.getOrDefault(num, new ArrayList<Integer>());
            indices.add(i);
            valueIndicesMap.put(num, indices);
        }
        Map<Integer, Set<Integer>> nextJumpMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < length; i++) {
            Set<Integer> nextJump = new HashSet<Integer>();
            if (i > 0)
                nextJump.add(i - 1);
            if (i < length - 1)
                nextJump.add(i + 1);
            int num = arr[i];
            List<Integer> indices = valueIndicesMap.getOrDefault(num, new ArrayList<Integer>());
            for (int index : indices) {
                if (index != i)
                    nextJump.add(index);
            }
            nextJumpMap.put(i, nextJump);
        }
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                int curSteps = dp[index] + 1;
                Set<Integer> nextJump = nextJumpMap.getOrDefault(index, new HashSet<Integer>());
                for (int nextIndex : nextJump) {
                    int prevSteps = dp[nextIndex];
                    if (curSteps < prevSteps) {
                        dp[nextIndex] = curSteps;
                        queue.offer(nextIndex);
                    }
                }
            }
        }
        return dp[length - 1];
    }
}