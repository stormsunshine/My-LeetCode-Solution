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
        return edgesCount == n - 1;
    }
}