class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0 || K == 0)
            return 0;
        int subarrays = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int left = 0, right = 0;
        int length = A.length;
        while (right < length) {
            int rightNum = A[right];
            int rightCount = map.getOrDefault(rightNum, 0) + 1;
            map.put(rightNum, rightCount);
            right++;
            while (map.size() > K) {
                int leftNum = A[left];
                int leftCount = map.getOrDefault(leftNum, 0) - 1;
                if (leftCount > 0)
                    map.put(leftNum, leftCount);
                else
                    map.remove(leftNum);
                left++;
            }
            int pointer = left;
            while (map.size() == K) {
                subarrays++;
                int curNum = A[pointer];
                int curCount = map.getOrDefault(curNum, 0) - 1;
                if (curCount > 0)
                    map.put(curNum, curCount);
                else
                    map.remove(curNum);
                pointer++;
            }
            pointer--;
            while (pointer >= left) {
                int curNum = A[pointer];
                int curCount = map.getOrDefault(curNum, 0) + 1;
                map.put(curNum, curCount);
                pointer--;
            }
        }
        return subarrays;
    }
}