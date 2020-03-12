class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyline = new ArrayList<List<Integer>>();
        TreeSet<Pair> set = new TreeSet<Pair>();
        for (int[] building : buildings) {
            int left = building[0], right = building[1], height = building[2];
            set.add(new Pair(left, -height));
            set.add(new Pair(right, height));
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        int prev = 0;
        for (Pair pair : set) {
            int key = pair.key, value = pair.value;
            if (value < 0)
                priorityQueue.offer(-value);
            else
                priorityQueue.remove(value);
            int curr = 0;
            if (!priorityQueue.isEmpty())
                curr = priorityQueue.peek();
            if (prev != curr) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(key);
                list.add(curr);
                skyline.add(list);
            }
            prev = curr;
        }
        return skyline;
    }
}

class Pair implements Comparable<Pair> {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Pair pair2) {
        if (this.key != pair2.key)
            return this.key - pair2.key;
        else
            return this.value - pair2.value;
    }
}