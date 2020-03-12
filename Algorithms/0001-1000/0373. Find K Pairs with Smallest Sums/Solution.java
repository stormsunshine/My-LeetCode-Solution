class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {
            public int compare(List<Integer> pair1, List<Integer> pair2) {
                int sum1 = 0, sum2 = 0;
                for (int num : pair1)
                    sum1 += num;
                for (int num : pair2)
                    sum2 += num;
                return sum2 - sum1;
            }
        });
        int length1 = nums1.length, length2 = nums2.length;
        for (int i = 0; i < length1; i++) {
            int num1 = nums1[i];
            for (int j = 0; j < length2; j++) {
                int num2 = nums2[j];
                List<Integer> pair = new ArrayList<Integer>(Arrays.asList(num1, num2));
                if (priorityQueue.size() < k)
                    priorityQueue.offer(pair);
                else {
                    List<Integer> topPair = priorityQueue.peek();
                    if (topPair.get(0) + topPair.get(1) > num1 + num2) {
                        priorityQueue.poll();
                        priorityQueue.offer(pair);
                    } else
                        break;
                }
            }
        }
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        while (!priorityQueue.isEmpty())
            pairs.add(priorityQueue.poll());
        Collections.reverse(pairs);
        return pairs;
    }
}