class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] flowers = new int[N];
        Map<Integer, List<Integer>> adjacentMap = new HashMap<Integer, List<Integer>>();
        for (int[] path : paths) {
            int garden1 = path[0] - 1, garden2 = path[1] - 1;
            List<Integer> pathList1 = adjacentMap.getOrDefault(garden1, new ArrayList<Integer>());
            pathList1.add(garden2);
            adjacentMap.put(garden1, pathList1);
            List<Integer> pathList2 = adjacentMap.getOrDefault(garden2, new ArrayList<Integer>());
            pathList2.add(garden1);
            adjacentMap.put(garden2, pathList2);
        }
        flowers[0] = 1;
        for (int i = 1; i < N; i++) {
            List<Integer> adjacent = adjacentMap.getOrDefault(i, new ArrayList<Integer>());
            boolean[] used = new boolean[5];
            for (int garden : adjacent) {
                int flower = flowers[garden];
                if (flower > 0)
                    used[flower] = true;
            }
            for (int j = 1; j < 5; j++) {
                if (!used[j]) {
                    flowers[i] = j;
                    break;
                }
            }
        }
        return flowers;
    }
}