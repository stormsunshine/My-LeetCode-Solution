class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int pipesCount = pipes.length;
        int newPipesCount = pipesCount + n;
        int[][] newPipes = new int[newPipesCount][3];
        for (int i = 0; i < pipesCount; i++) {
            int[] pipe = pipes[i];
            int start = pipe[0], end = pipe[1], cost = pipe[2];
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }
            newPipes[i][0] = start;
            newPipes[i][1] = end;
            newPipes[i][2] = cost;
        }
        for (int i = 0; i < n; i++) {
            newPipes[pipesCount + i][0] = 0;
            newPipes[pipesCount + i][1] = i + 1;
            newPipes[pipesCount + i][2] = wells[i];
        }
        Arrays.sort(newPipes, new Comparator<int[]>() {
            public int compare(int[] pipe1, int[] pipe2) {
                return pipe1[2] - pipe2[2];
            }
        });
        Map<Integer, Integer> nodeGroupMap = new HashMap<Integer, Integer>();
        Map<Integer, Set<Integer>> groupNodesMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i <= n; i++) {
            nodeGroupMap.put(i, i);
            Set<Integer> set = new HashSet<Integer>();
            set.add(i);
            groupNodesMap.put(i, set);
        }
        int totalCost = 0;
        for (int i = 0; i < newPipesCount; i++) {
            int start = newPipes[i][0], end = newPipes[i][1], cost = newPipes[i][2];
            int group1 = nodeGroupMap.get(start), group2 = nodeGroupMap.get(end);
            if (group1 != group2) {
                totalCost += cost;
                Set<Integer> set1 = groupNodesMap.getOrDefault(group1, new HashSet<Integer>());
                Set<Integer> set2 = groupNodesMap.getOrDefault(group2, new HashSet<Integer>());
                if (group1 < group2) {
                    for (int node : set2)
                        nodeGroupMap.put(node, group1);
                    set1.addAll(set2);
                    groupNodesMap.put(group1, set1);
                    groupNodesMap.remove(group2);
                } else {
                    for (int node : set1)
                        nodeGroupMap.put(node, group2);
                    set2.addAll(set1);
                    groupNodesMap.put(group2, set2);
                    groupNodesMap.remove(group1);
                }
            }
        }
        return totalCost;
    }
}