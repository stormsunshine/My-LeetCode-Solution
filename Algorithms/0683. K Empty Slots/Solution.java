class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        Map<Integer, Integer> dayIndexMap = new HashMap<Integer, Integer>();
        int length = bulbs.length;
        for (int i = 0; i < length; i++)
            dayIndexMap.put(i + 1, bulbs[i]);
        TreeSet<Interval> set = new TreeSet<Interval>();
        int bulb1 = bulbs[0];
        if (bulb1 == 1)
            set.add(new Interval(2, length));
        else if (bulb1 == length)
            set.add(new Interval(1, length - 1));
        else {
            set.add(new Interval(1, bulb1 - 1));
            set.add(new Interval(bulb1 + 1, length));
        }
        for (int i = 1; i < length; i++) {
            int day = i + 1;
            int bulb = bulbs[i];
            Interval curr = set.floor(new Interval(bulb, length));
            set.remove(curr);
            if (curr.start == bulb) {
                if (K == 0 && bulb > 1)
                    return day;
                else if (curr.end < length && curr.end - bulb == K)
                    return day;
                else
                    set.add(new Interval(bulb + 1, curr.end));
            } else if (curr.end == bulb) {
                if (K == 0 && bulb < length)
                    return day;
                else if (curr.start > 1 && bulb - curr.start == K)
                    return day;
                else
                    set.add(new Interval(curr.start, bulb - 1));
            } else {
                if (curr.start > 1 && bulb - curr.start == K || curr.end < length && curr.end - bulb == K)
                    return day;
                else {
                    set.add(new Interval(curr.start, bulb - 1));
                    set.add(new Interval(bulb + 1, curr.end));
                }
            }
        }
        return -1;
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