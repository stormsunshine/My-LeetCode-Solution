class Solution {
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = 2;

    public int makeConnected(int n, int[][] connections) {
        int length = connections.length;
        if (length < n - 1)
            return -1;
        Map<Integer, List<Integer>> connectionsMap = new HashMap<Integer, List<Integer>>();
        for (int[] connection : connections) {
            int computer1 = connection[0], computer2 = connection[1];
            List<Integer> list1 = connectionsMap.getOrDefault(computer1, new ArrayList<Integer>());
            list1.add(computer2);
            connectionsMap.put(computer1, list1);
            List<Integer> list2 = connectionsMap.getOrDefault(computer2, new ArrayList<Integer>());
            list2.add(computer1);
            connectionsMap.put(computer2, list2);
        }
        int[] colors = new int[n];
        int[] groups = new int[n];
        for (int i = 0; i < n; i++)
            groups[i] = i;
        for (int i = 0; i < n; i++) {
            if (colors[i] == WHITE)
                breadthFirstSearch(connectionsMap, colors, groups, i);
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++)
            set.add(groups[i]);
        return set.size() - 1;
    }

    public void breadthFirstSearch(Map<Integer, List<Integer>> connectionsMap, int[] colors, int[] groups, int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        colors[start] = GRAY;
        while (!queue.isEmpty()) {
            int computer = queue.poll();
            int group = groups[computer];
            List<Integer> list = connectionsMap.getOrDefault(computer, new ArrayList<Integer>());
            for (int nextComputer : list) {
                if (colors[nextComputer] == WHITE) {
                    queue.offer(nextComputer);
                    colors[nextComputer] = GRAY;
                    groups[nextComputer] = group;
                }
            }
            colors[start] = BLACK;
        }
    }
}