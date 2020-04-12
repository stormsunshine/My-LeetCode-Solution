class Solution {
    public int numSquarefulPerms(int[] A) {
        int length = A.length;
        Map<Integer, List<Integer>> graphMap = new HashMap<Integer, List<Integer>>();
        Integer[][] memo = new Integer[length][1 << length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = A[i] + A[j];
                int sqrt = (int) Math.sqrt(sum);
                if (sqrt * sqrt == sum) {
                    List<Integer> list1 = graphMap.getOrDefault(i, new ArrayList<Integer>());
                    List<Integer> list2 = graphMap.getOrDefault(j, new ArrayList<Integer>());
                    list1.add(j);
                    list2.add(i);
                    graphMap.put(i, list1);
                    graphMap.put(j, list2);
                }
            }
        }
        int[] factorials = new int[13];
        factorials[0] = 1;
        for (int i = 1; i <= 12; i++)
            factorials[i] = factorials[i - 1] * i;
        int permutations = 0;
        for (int i = 0; i < length; i++)
            permutations += depthFirstSearch(i, 1 << i, length, graphMap, memo);
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : A) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }
        List<Integer> valuesList = new ArrayList<Integer>(countMap.values());
        for (int value : valuesList)
            permutations /= factorials[value];
        return permutations;
    }

    public int depthFirstSearch(int node, int visited, int length, Map<Integer, List<Integer>> graphMap, Integer[][] memo) {
        if (visited == (1 << length) - 1)
            return 1;
        if (memo[node][visited] != null)
            return memo[node][visited];
        int permutations = 0;
        List<Integer> list = graphMap.getOrDefault(node, new ArrayList<Integer>());
        for (int next : list) {
            if (((visited >> next) & 1) == 0)
                permutations += depthFirstSearch(next, visited | (1 << next), length, graphMap, memo);
        }
        memo[node][visited] = permutations;
        return permutations;
    }
}