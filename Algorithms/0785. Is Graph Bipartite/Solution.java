class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] colors = new int[nodes];
        Arrays.fill(colors, -1);
        for (int i = 0; i < nodes; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                Stack<Integer> stack = new Stack<Integer>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int start = stack.pop();
                    int color = colors[start];
                    int[] ends = graph[start];
                    for (int end : ends) {
                        if (colors[end] == -1) {
                            colors[end] = 1 - color;
                            stack.push(end);
                        } else if (colors[start] == colors[end])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}