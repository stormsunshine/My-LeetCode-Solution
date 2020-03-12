class ExamRoom {
    int seatsCount;
    TreeSet<Interval> set;

    public ExamRoom(int N) {
        seatsCount = N;
        set = new TreeSet<Interval>();
        set.add(new Interval(0, N - 1));
    }
    
    public int seat() {
        if (set.size() == 1) {
            Interval interval = set.first();
            int start = interval.start, end = interval.end;
            if (start == 0) {
                if (start < end)
                    set.add(new Interval(start + 1, end));
                set.remove(interval);
                return 0;
            } else if (end == seatsCount - 1) {
                if (start < end)
                    set.add(new Interval(start, end - 1));
                set.remove(interval);
                return seatsCount - 1;
            } else {
                int mid = (end - start) / 2 + start;
                if (start < mid)
                    set.add(new Interval(start, mid - 1));
                if (mid < end)
                    set.add(new Interval(mid + 1, end));
                set.remove(interval);
                return mid;
            }
        } else {
            Interval firstInterval = set.first();
            int firstDistance = firstInterval.end - firstInterval.start;
            int firstSeat = firstInterval.start;
            if (firstInterval.start != 0) {
                firstDistance /= 2;
                firstSeat += firstDistance;
            }
            Interval lastInterval = set.last();
            int lastDistance = lastInterval.end - lastInterval.start;
            int lastSeat = lastInterval.end;
            if (lastInterval.end != seatsCount - 1) {
                lastDistance /= 2;
                lastSeat = lastInterval.start + lastDistance;
            }
            int maxDistance = firstDistance;
            int maxSeat = firstSeat;
            if (lastDistance > firstDistance) {
                maxDistance = lastDistance;
                maxSeat = lastSeat;
            }
            Iterator<Interval> iterator = set.iterator();
            while (iterator.hasNext()) {
                Interval interval = iterator.next();
                if (interval.equals(firstInterval) || interval.equals(lastInterval))
                    continue;
                int distance = (interval.end - interval.start) / 2;
                int seat = interval.start + distance;
                if (distance > maxDistance || distance == maxDistance && seat < maxSeat) {
                    maxDistance = distance;
                    maxSeat = seat;
                }
            }
            Interval curr = set.floor(new Interval(maxSeat - 1, seatsCount - 1));
            if (curr == null || curr.end < maxSeat) {
                Interval next = set.floor(new Interval(maxSeat, seatsCount - 1));
                if (maxSeat < next.end)
                    set.add(new Interval(maxSeat + 1, next.end));
                set.remove(next);
            } else {
                if (curr.start < maxSeat)
                    set.add(new Interval(curr.start, maxSeat - 1));
                if (maxSeat < curr.end)
                    set.add(new Interval(maxSeat + 1, curr.end));
                set.remove(curr);
            }
            return maxSeat;
        }
    }
    
    public void leave(int p) {
        Interval prev = set.floor(new Interval(p - 1, p - 1));
        Interval next = set.ceiling(new Interval(p + 1, p + 1));
        if (prev == null && next == null)
            set.add(new Interval(p, p));
        else if (prev == null) {
            if (next.start == p + 1) {
                set.add(new Interval(p, next.end));
                set.remove(next);
            } else
                set.add(new Interval(p, p));
        } else if (next == null) {
            if (prev.end == p - 1) {
                set.add(new Interval(prev.start, p));
                set.remove(prev);
            } else
                set.add(new Interval(p, p));
        } else {
            if (prev.end == p - 1 && next.start == p + 1) {
                set.add(new Interval(prev.start, next.end));
                set.remove(prev);
                set.remove(next);
            } else if (prev.end == p - 1) {
                set.add(new Interval(prev.start, p));
                set.remove(prev);
            } else if (next.start == p + 1) {
                set.add(new Interval(p, next.end));
                set.remove(next);
            } else
                set.add(new Interval(p, p));
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
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */