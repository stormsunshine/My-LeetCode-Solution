/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allSchedules = new ArrayList<Interval>();
        for (List<Interval> list : schedule)
            allSchedules.addAll(list);
        Collections.sort(allSchedules, new Comparator<Interval>() {
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.start != interval2.start)
                    return interval1.start - interval2.start;
                else
                    return interval1.end - interval2.end;
            }
        });
        List<Interval> sorted = new ArrayList<Interval>();
        Interval interval0 = allSchedules.get(0);
        int curStart = interval0.start, curEnd = interval0.end;
        int size = allSchedules.size();
        for (int i = 1; i < size; i++) {
            Interval interval = allSchedules.get(i);
            if (interval.start <= curEnd)
                curEnd = Math.max(curEnd, interval.end);
            else {
                sorted.add(new Interval(curStart, curEnd));
                curStart = interval.start;
                curEnd = interval.end;
            }
        }
        sorted.add(new Interval(curStart, curEnd));
        List<Interval> freeTimeList = new ArrayList<Interval>();
        int sortedSize = sorted.size();
        for (int i = 1; i < sortedSize; i++)
            freeTimeList.add(new Interval(sorted.get(i - 1).end, sorted.get(i).start));
        return freeTimeList;
    }
}