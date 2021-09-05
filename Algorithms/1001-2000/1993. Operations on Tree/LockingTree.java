class LockingTree {
    int n;
    int[] parent;
    int[] locks;
    Set<Integer>[] children;

    public LockingTree(int[] parent) {
        n = parent.length;
        this.parent = parent;
        locks = new int[n];
        children = new Set[n];
        for (int i = 0; i < n; i++)
            children[i] = new HashSet<Integer>();
        for (int i = 1; i < n; i++) {
            int prev = parent[i];
            children[prev].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (locks[num] == 0) {
            locks[num] = user;
            return true;
        } else
            return false;
    }
    
    public boolean unlock(int num, int user) {
        if (locks[num] == user) {
            locks[num] = 0;
            return true;
        } else
            return false;
    }
    
    public boolean upgrade(int num, int user) {
        int node = num;
        while (node >= 0) {
            if (locks[node] != 0)
                return false;
            node = parent[node];
        }
        if (!breadthFirstSearch(num))
            return false;
        unlockAllDescendants(num);
        locks[num] = user;
        return true;
    }

    private boolean breadthFirstSearch(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(num);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (locks[node] > 0)
                return true;
            Set<Integer> set = children[node];
            for (int next : set)
                queue.offer(next);
        }
        return false;
    }

    private void unlockAllDescendants(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(num);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            locks[node] = 0;
            Set<Integer> set = children[node];
            for (int next : set)
                queue.offer(next);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */