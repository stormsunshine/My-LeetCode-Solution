/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        List<Integer> numsList = new ArrayList<Integer>();
        List<Integer> depthsList = new ArrayList<Integer>();
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        for (NestedInteger element : nestedList) {
            queue.offer(element);
            depthQueue.offer(1);
        }
        while (!queue.isEmpty()) {
            NestedInteger element = queue.poll();
            int depth = depthQueue.poll();
            maxDepth = Math.max(maxDepth, depth);
            if (element.isInteger()) {
                int num = element.getInteger();
                numsList.add(num);
                depthsList.add(depth);
            } else {
                List<NestedInteger> list = element.getList();
                for (NestedInteger nextElement : list) {
                    queue.offer(nextElement);
                    depthQueue.offer(depth + 1);
                }
            }
        }
        int depthSum = 0;
        int size = numsList.size();
        for (int i = 0; i < size; i++) {
            int num = numsList.get(i), depth = depthsList.get(i);
            int weight = maxDepth - depth + 1;
            depthSum += num * weight;
        }
        return depthSum;
    }
}