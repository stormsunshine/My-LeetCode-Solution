class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> endSet = new HashSet<Integer>();
        for (List<Integer> edge : edges)
            endSet.add(edge.get(1));
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i))
                list.add(i);
        }
        return list;
    }
}