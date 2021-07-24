class Solution {
    static final int MAXD = 17;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length;
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++)
            edges.add(new ArrayList<Integer>());
        int rootIndex = -1;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1)
                rootIndex = i;
            else
                edges.get(parents[i]).add(i);
        }
        List<List<int[]>> stored = new ArrayList<List<int[]>>();
        for (int i = 0; i < n; i++)
            stored.add(new ArrayList<int[]>());
        int queriesCount = queries.length;
        int[] ans = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++)
            stored.get(queries[i][0]).add(new int[]{i, queries[i][1]});
        TrieNode root = new TrieNode();
        depthFirstSearch(ans, root, rootIndex, edges, stored);
        return ans;
    }

    public void insert(TrieNode root, int x) {
        TrieNode curr = root;
        for (int i = MAXD; i >= 0; i--) {
            if ((x & (1 << i)) != 0) {
                if (curr.children[1] == null)
                    curr.children[1] = new TrieNode();
                curr = curr.children[1];
            } else {
                if (curr.children[0] == null)
                    curr.children[0] = new TrieNode();
                curr = curr.children[0];
            }
            curr.count++;
        }
    }

    public int query(TrieNode root, int x) {
        int queryMax = 0;
        TrieNode curr = root;
        for (int i = MAXD; i >= 0; i--) {
            if ((x & (1 << i)) != 0) {
                if (curr.children[0] != null && curr.children[0].count > 0) {
                    queryMax |= 1 << i;
                    curr = curr.children[0];
                } else
                    curr = curr.children[1];
            } else {
                if (curr.children[1] != null && curr.children[1].count > 0) {
                    queryMax |= 1 << i;
                    curr = curr.children[1];
                } else
                    curr = curr.children[0];
            }
        }
        return queryMax;
    }

    public void erase(TrieNode root, int x) {
        TrieNode curr = root;
        for (int i = MAXD; i >= 0; i--) {
            if ((x & (1 << i)) != 0)
                curr = curr.children[1];
            else
                curr = curr.children[0];
            curr.count--;
        }
    }

    public void depthFirstSearch(int[] ans, TrieNode root, int node, List<List<Integer>> edges, List<List<int[]>> stored) {
        insert(root, node);
        List<int[]> list = stored.get(node);
        for (int[] pair : list) {
            int index = pair[0], num = pair[1];
            ans[index] = query(root, num);
        }
        List<Integer> nextNodes = edges.get(node);
        for (int nextNode : nextNodes)
            depthFirstSearch(ans, root, nextNode, edges, stored);
        erase(root, node);
    }
}

class TrieNode {
    int count;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
        count = 0;
    }
}