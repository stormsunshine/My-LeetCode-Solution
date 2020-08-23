class Solution {
    public int findLatestStep(int[] arr, int m) {
        int length = arr.length;
        TreeMap<Integer, Integer> groupMap = new TreeMap<Integer, Integer>();
        groupMap.put(1, length);
        Map<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
        lengthMap.put(length, 1);
        for (int i = length - 1; i >= 0; i--) {
            if (lengthMap.containsKey(m))
                return i + 1;
            int index = arr[i];
            int start = groupMap.floorKey(index);
            int end = groupMap.get(start);
            int groupLength = end - start + 1;
            if (index == start && index == end) {
                groupMap.remove(start);
                int count = lengthMap.get(groupLength) - 1;
                if (count == 0)
                    lengthMap.remove(groupLength);
                else
                    lengthMap.put(1, count);
            } else if (index == start) {
                groupMap.put(start + 1, end);
                groupMap.remove(start);
                int prevCount = lengthMap.get(groupLength) - 1;
                if (prevCount == 0)
                    lengthMap.remove(groupLength);
                else
                    lengthMap.put(groupLength, prevCount);
                int newLength = groupLength - 1;
                int newCount = lengthMap.getOrDefault(newLength, 0) + 1;
                lengthMap.put(newLength, newCount);
            } else if (index == end) {
                groupMap.put(start, end - 1);
                int prevCount = lengthMap.get(groupLength) - 1;
                if (prevCount == 0)
                    lengthMap.remove(groupLength);
                else
                    lengthMap.put(groupLength, prevCount);
                int newLength = groupLength - 1;
                int newCount = lengthMap.getOrDefault(newLength, 0) + 1;
                lengthMap.put(newLength, newCount);
            } else {
                groupMap.put(start, index - 1);
                groupMap.put(index + 1, end);
                int prevCount = lengthMap.get(groupLength) - 1;
                if (prevCount == 0)
                    lengthMap.remove(groupLength);
                else
                    lengthMap.put(groupLength, prevCount);
                int newLength1 = index - start, newLength2 = end - index;
                int newCount1 = lengthMap.getOrDefault(newLength1, 0) + 1;
                lengthMap.put(newLength1, newCount1);
                int newCount2 = lengthMap.getOrDefault(newLength2, 0) + 1;
                lengthMap.put(newLength2, newCount2);
            }
        }
        return -1;
    }
}