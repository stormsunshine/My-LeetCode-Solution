class Solution {
    public int minOperations(int[] target, int[] arr) {
        int length1 = target.length, length2 = arr.length;
        Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < length1; i++)
            targetMap.put(target[i], i);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length2; i++) {
            int num = arr[i];
            if (targetMap.containsKey(num))
                list.add(targetMap.get(num));
        }
        int longestIncreasing = lengthOfLIS(list);
        return target.length - longestIncreasing;
    }

    public int lengthOfLIS(List<Integer> list) {
        int length = 1, size = list.size();
        if (size == 0)
            return 0;
        int[] d = new int[size + 1];
        d[length] = list.get(0);
        for (int i = 1; i < size; ++i) {
            if (list.get(i) > d[length]) {
                d[++length] = list.get(i);
            } else {
                int left = 1, right = length, pos = 0;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < list.get(i)) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = list.get(i);
            }
        }
        return length;
    }
}