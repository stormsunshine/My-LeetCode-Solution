class TreeAncestor {
    int[] parent;
    Map<Integer, List<Integer>> childAncestorsMap = new HashMap<Integer, List<Integer>>();

    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        for (int i = 1; i < n; i++) {
            int p = parent[i];
            List<Integer> ancestors = new ArrayList<Integer>();
            ancestors.add(p);
            childAncestorsMap.put(i, ancestors);
        }
        int size = 1;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < n; i++) {
                List<Integer> ancestors = childAncestorsMap.get(i);
                if (ancestors.size() < size)
                    continue;
                int ancestor = ancestors.get(size - 1);
                if (ancestor == 0)
                    continue;
                List<Integer> nextList = childAncestorsMap.get(ancestor);
                if (nextList.size() < size)
                    continue;
                int nextAncestor = childAncestorsMap.get(ancestor).get(size - 1);
                ancestors.add(nextAncestor);
                flag = true;
            }
            size++;
        }
    }
    
    public int getKthAncestor(int node, int k) {
        if (k == 0)
            return node;
        if (node == 0)
            return -1;
        if (k == 1)
            return parent[node];
        int index = (int) (Math.log(k) / Math.log(2));
        List<Integer> ancestors = childAncestorsMap.get(node);
        if (ancestors.size() <= index)
            return -1;
        return getKthAncestor(ancestors.get(index), k - (int) Math.pow(2, index));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */