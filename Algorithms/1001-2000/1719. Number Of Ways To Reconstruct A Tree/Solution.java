class Solution {
    public int checkWays(int[][] pairs) {
        int maxValue = 0;
        for (int[] pair : pairs)
            maxValue = Math.max(maxValue, Math.max(pair[0], pair[1]));
        boolean[][] relations = new boolean[maxValue + 1][maxValue + 1];
        List<Integer>[] lists = new List[maxValue + 1];
        for (int i = 0; i <= maxValue; i++)
            lists[i] = new ArrayList<Integer>();
        for (int[] pair : pairs) {
            int value1 = pair[0], value2 = pair[1];
            relations[value1][value2] = true;
            relations[value2][value1] = true;
            lists[value1].add(value2);
            lists[value2].add(value1);
        }
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 1; i <= maxValue; i++) {
            if (!lists[i].isEmpty()) {
                indices.add(i);
                relations[i][i] = true;
            }
        }
        Collections.sort(indices, new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                return lists[index1].size() - lists[index2].size();
            }
        });
        boolean equal = false;
        int rootCount = 0;
        int size = indices.size();
        for (int i = 0; i < size; i++) {
            int j = i + 1;
            while (j < size && !relations[indices.get(i)][indices.get(j)])
                j++;
            if (j < size) {
                if (lists[indices.get(i)].size() == lists[indices.get(j)].size())
                    equal = true;
                for (int value : lists[indices.get(i)]) {
                    if (!relations[value][indices.get(j)])
                        return 0;
                }
            } else
                rootCount++;
        }
        if (rootCount > 1)
            return 0;
        else
            return equal ? 2 : 1;
    }
}