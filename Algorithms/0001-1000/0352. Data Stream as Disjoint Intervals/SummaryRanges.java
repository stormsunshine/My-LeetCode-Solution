class SummaryRanges {
    TreeSet<Interval> set;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new TreeSet<Interval>();
    }
    
    public void addNum(int val) {
        Interval curr = new Interval(val, val);
        if (set.contains(curr))
            return;
        Interval prev = set.floor(new Interval(val, val - 1));
        if (prev != null) {
            if (prev.end >= val)
                return;
            else if (prev.end == val - 1) {
                curr.start = prev.start;
                set.remove(prev);
            }
        }
        Interval next = set.ceiling(new Interval(curr.start, curr.end + 1));
        if (next != null) {
            if (next.start == val)
                return;
            else if (next.start == val + 1) {
                curr.end = next.end;
                set.remove(next);
            }
        }
        set.add(curr);
    }
    
    public int[][] getIntervals() {
        int size = set.size();
        int[][] array = new int[size][2];
        Iterator<Interval> iterator = set.iterator();
        for (int i = 0; i < size; i++) {
            Interval interval = iterator.next();
            array[i][0] = interval.start;
            array[i][1] = interval.end;
        }
        return array;
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval interval2) {
        if (this.start != interval2.start)
            return this.start - interval2.start;
        else
            return this.end - interval2.end;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Interval) {
            Interval interval2 = (Interval) obj;
            return this.start == interval2.start && this.end == interval2.end;
        } else
            return false;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */