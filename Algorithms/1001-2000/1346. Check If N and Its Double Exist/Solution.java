class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : arr) {
            if (num != 0)
                set.add(num);
            else {
                if (!set.add(num))
                    return true;
            }
        }
        for (int num : arr) {
            if (num != 0 && set.contains(num * 2))
                return true;
        }
        return false;
    }
}