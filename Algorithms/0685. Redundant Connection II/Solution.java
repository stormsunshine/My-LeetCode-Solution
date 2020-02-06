class Solution {
    int[] parents;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        parents = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++)
            parents[i] = i;
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parents[node2] != node2)
                conflict = i;
            else {
                if (conflict < 0 && cycle < 0) {
                    int ancestor1 = findAncestor(node1);
                    int ancestor2 = findAncestor(node2);
                    if (ancestor1 == ancestor2)
                        cycle = i;
                }
                parents[node2] = node1;
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        }
        int[] conflictEdge = edges[conflict];
        if (containsCycle(conflictEdge[1])) {
            int[] redundant = new int[2];
            redundant[1] = conflictEdge[1];
            redundant[0] = parents[conflictEdge[1]];
            return redundant;
        } else {
            int[] redundant = {conflictEdge[0], conflictEdge[1]};
            return redundant;
        }
    }

    public boolean containsCycle(int node) {
        int tempNode = node;
        while (parents[node] != node) {
            if (parents[node] == tempNode)
                return true;
            node = parents[node];
        }
        return false;
    }

    public int findAncestor(int node) {
        while (parents[node] != node)
            node = parents[node];
        return node;
    }
}