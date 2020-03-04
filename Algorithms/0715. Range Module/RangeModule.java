class RangeModule {
    TreeSet<Interval> set;

    public RangeModule() {
        set = new TreeSet<Interval>();
    }
    
    public void addRange(int left, int right) {
        TreeSet<Interval> prevSet = new TreeSet<Interval>(set);
        for (Interval interval : prevSet) {
            if (interval.end >= left && interval.start <= right) {
                left = Math.min(left, interval.start);
                right = Math.max(right, interval.end);
                set.remove(interval);
            } else if (interval.start > right)
                break;
        }
        set.add(new Interval(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        Interval curr = new Interval(left, right);
        Interval prev = set.floor(curr);
        if (prev != null && prev.end >= right)
            return true;
        else {
            Interval next = set.ceiling(curr);
            if (next != null && next.start == left)
                return true;
            else
                return false;
        }
    }
    
    public void removeRange(int left, int right) {
        TreeSet<Interval> prevSet = new TreeSet<Interval>(set);
        for (Interval interval : prevSet) {
            if (interval.end >= left && interval.start <= right) {
                set.remove(interval);
                if (interval.start < left)
                    set.add(new Interval(interval.start, left));
                if (interval.end > right)
                    set.add(new Interval(right, interval.end));
            } else if (interval.start > right)
                break;
        }
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

    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */