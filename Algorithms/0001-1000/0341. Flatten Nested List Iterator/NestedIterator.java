/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int size;
    int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for (NestedInteger nestedInteger : nestedList)
            queue.offer(nestedInteger);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInteger = queue.poll();
                if (flag) {
                    if (nestedInteger.isInteger())
                        list.add(nestedInteger.getInteger());
                    else {
                        flag = false;
                        List<NestedInteger> curList = nestedInteger.getList();
                        for (NestedInteger element : curList)
                            queue.offer(element);
                    }
                } else {
                    if (nestedInteger.isInteger())
                        queue.offer(nestedInteger);
                    else {
                        List<NestedInteger> curList = nestedInteger.getList();
                        for (NestedInteger element : curList)
                            queue.offer(element);
                    }
                }
            }
        }
        size = list.size();
        index = 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int next = list.get(index);
            index++;
            return next;
        } else
            return -1;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */