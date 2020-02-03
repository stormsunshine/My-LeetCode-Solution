class TimeMap {
    Map<String, List<TimestampValue>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, List<TimestampValue>>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimestampValue> list = map.getOrDefault(key, new ArrayList<TimestampValue>());
        TimestampValue timestampValue = new TimestampValue(timestamp, value);
        list.add(timestampValue);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<TimestampValue> list = map.getOrDefault(key, new ArrayList<TimestampValue>());
        int index = binarySearch(list, timestamp);
        if (index < 0)
            index = -index - 2;
        if (index < 0)
            return "";
        TimestampValue timestampValue = list.get(index);
        return timestampValue.value;
    }

    public int binarySearch(List<TimestampValue> list, int timestamp) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            TimestampValue timestampValue = list.get(mid);
            int midTimestamp = timestampValue.timestamp;
            if (midTimestamp == timestamp)
                return mid;
            else if (midTimestamp > timestamp)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}

class TimestampValue implements Comparable<TimestampValue> {
    int timestamp;
    String value;

    public TimestampValue() {
        
    }

    public TimestampValue(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public int compareTo(TimestampValue timestampValue2) {
        return this.timestamp - timestampValue2.timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */