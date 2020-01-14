public class ZigzagIterator {
    List<Integer> list;
    int size;
    int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<Integer>();
        int size1 = v1.size(), size2 = v2.size();
        int minSize = Math.min(size1, size2);
        int index = 0;
        while (index < minSize) {
            list.add(v1.get(index));
            list.add(v2.get(index));
            index++;
        }
        while (index < size1) {
            list.add(v1.get(index));
            index++;
        }
        while (index < size2) {
            list.add(v2.get(index));
            index++;
        }
        size = size1 + size2;
        this.index = 0;
    }

    public int next() {
        if (!hasNext())
            return -1;
        int next = list.get(index);
        index++;
        return next;
    }

    public boolean hasNext() {
        return index < size;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */