class Solution {
    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            int num = arr[i];
            int count = map.getOrDefault(num, 0);
            count++;
            if (count * 4 > length)
                return num;
            map.put(num, count);
        }
        return 0;
    }
}