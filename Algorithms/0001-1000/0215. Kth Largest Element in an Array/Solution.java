class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int length = nums.length;
        for (int i = 0; i < k; i++)
            priorityQueue.offer(nums[i]);
        for (int i = k; i < length; i++) {
            int kthNum = priorityQueue.peek();
            int num = nums[i];
            if (num > kthNum) {
                priorityQueue.offer(num);
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}