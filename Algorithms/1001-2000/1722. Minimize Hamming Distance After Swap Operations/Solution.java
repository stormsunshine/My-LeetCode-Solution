class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int length = source.length;
        int[] parent = new int[length];
        for (int i = 0; i < length; i++)
            parent[i] = i;
        for (int[] swap : allowedSwaps) {
            int index1 = swap[0], index2 = swap[1];
            if (find(parent, index1) != find(parent, index2))
                union(parent, index1, index2);
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < length; i++) {
            int root = find(parent, i);
            List<Integer> indices = map.getOrDefault(root, new ArrayList<Integer>());
            indices.add(i);
            map.put(root, indices);
        }
        int distance = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
            List<Integer> indices = entry.getValue();
            int size = indices.size();
            for (int i = 0; i < size; i++) {
                int index = indices.get(i);
                int num1 = source[index], num2 = target[index];
                int count1 = counts.getOrDefault(num1, 0) + 1;
                if (count1 != 0)
                    counts.put(num1, count1);
                else
                    counts.remove(num1);
                int count2 = counts.getOrDefault(num2, 0) - 1;
                if (count2 != 0)
                    counts.put(num2, count2);
                else
                    counts.remove(num2);
            }
            for (Map.Entry<Integer, Integer> countEntry : counts.entrySet())
                distance += Math.abs(countEntry.getValue());
        }
        return distance / 2;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
            index = parent[index];
        }
        return index;
    }
}