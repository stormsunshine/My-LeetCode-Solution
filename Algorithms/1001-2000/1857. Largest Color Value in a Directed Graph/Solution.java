class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int length = colors.length();
        int[] indegrees = new int[length];
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            indegrees[end]++;
            List<Integer> list = edgesMap.getOrDefault(start, new ArrayList<Integer>());
            list.add(end);
            edgesMap.put(start, list);
        }
        int remain = length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            if (indegrees[i] == 0)
                queue.offer(i);
        }
        int[][] dp = new int[length][26];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            remain--;
            dp[node][colors.charAt(node) - 'a']++;
            List<Integer> list = edgesMap.getOrDefault(node, new ArrayList<Integer>());
            for (int nextNode : list) {
                indegrees[nextNode]--;
                if (indegrees[nextNode] == 0)
                    queue.offer(nextNode);
                for (int i = 0; i < 26; i++)
                    dp[nextNode][i] = Math.max(dp[nextNode][i], dp[node][i]);
            }
        }
        if (remain > 0)
            return -1;
        int maxValue = 0;
        for (int i = 0; i < length; i++)
            maxValue = Math.max(maxValue, Arrays.stream(dp[i]).max().getAsInt());
        return maxValue;
    }
}