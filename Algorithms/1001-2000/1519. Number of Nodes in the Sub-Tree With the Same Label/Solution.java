class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> edgesMap = new HashMap<Integer, Set<Integer>>();
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1];
            Set<Integer> set0 = edgesMap.getOrDefault(node0, new HashSet<Integer>());
            Set<Integer> set1 = edgesMap.getOrDefault(node1, new HashSet<Integer>());
            set0.add(node1);
            set1.add(node0);
            edgesMap.put(node0, set0);
            edgesMap.put(node1, set1);
        }
        Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
        Map<Integer, int[]> labelsMap = new HashMap<Integer, int[]>();
        int[] levels = new int[n];
        Arrays.fill(levels, -1);
        levels[0] = 0;
        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        list.add(0);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] labelsCount = new int[26];
            char label = labels.charAt(node);
            labelsCount[label - 'a']++;
            labelsMap.put(node, labelsCount);
            int level = levels[node];
            Set<Integer> nextNodes = edgesMap.getOrDefault(node, new HashSet<Integer>());
            for (int nextNode : nextNodes) {
                if (levels[nextNode] < 0) {
                    parentMap.put(nextNode, node);
                    list.add(nextNode);
                    levels[nextNode] = level + 1;
                    queue.offer(nextNode);
                }
            }
        }
        int[] counts = new int[n];
        for (int i = list.size() - 1; i >= 0; i--) {
            int node = list.get(i);
            char label = labels.charAt(node);
            int labelIndex = label - 'a';
            int[] labelsCount = labelsMap.get(node);
            counts[node] = labelsCount[labelIndex];
            int parent = parentMap.getOrDefault(node, -1);
            if (parent >= 0) {
                int[] parentLabelsCount = labelsMap.get(parent);
                for (int j = 0; j < 26; j++)
                    parentLabelsCount[j] += labelsCount[j];
                labelsMap.put(parent, parentLabelsCount);
            }
        }
        return counts;
    }
}