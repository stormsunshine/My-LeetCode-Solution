class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        int edgesCount = 0;
        for (int i = 0; i < n; i++) {
            int curLeft = leftChild[i], curRight = rightChild[i];
            if (curLeft >= 0) {
                edgesCount++;
                if (parents[curLeft] < 0)
                    parents[curLeft] = i;
                else
                    return false;
            }
            if (curRight >= 0) {
                edgesCount++;
                if (parents[curRight] < 0)
                    parents[curRight] = i;
                else
                    return false;
            }
        }
        if (edgesCount != n - 1)
            return false;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                if (root < 0)
                    root = i;
                else
                    return false;
            }
        }
        if (root < 0)
            return false;
        int visitCount = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visitCount++;
            int left = leftChild[node], right = rightChild[node];
            if (left >= 0)
                queue.offer(left);
            if (right >= 0)
                queue.offer(right);
        }
        return visitCount == n;
    }
}