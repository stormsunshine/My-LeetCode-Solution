class Solution {
    public boolean canReach(int[] arr, int start) {
        int length = arr.length;
        boolean[] canReach = new boolean[length];
        canReach[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int step = arr[index];
            int left = index - step, right = index + step;
            if (left >= 0) {
                if (arr[left] == 0)
                    return true;
                else if (!canReach[left]) {
                    canReach[left] = true;
                    queue.offer(left);
                }
            }
            if (right < length) {
                if (arr[right] == 0)
                    return true;
                else if (!canReach[right]) {
                    canReach[right] = true;
                    queue.offer(right);
                }
            }
        }
        return false;
    }
}