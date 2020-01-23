class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : A) {
            if (!set.add(num))
                return num;
        }
        return -1;
    }
}