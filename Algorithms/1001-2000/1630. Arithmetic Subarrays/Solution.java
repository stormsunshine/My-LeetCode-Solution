class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<Boolean>();
        int queries = l.length;
        for (int i = 0; i < queries; i++) {
            int start = l[i], end = r[i];
            if (end - start < 2)
                list.add(true);
            else {
                int[] subarray = new int[end - start + 1];
                System.arraycopy(nums, start, subarray, 0, end - start + 1);
                list.add(check(subarray));
            }
        }
        return list;
    }

    public boolean check(int[] subarray) {
        Arrays.sort(subarray);
        int length = subarray.length;
        long min = subarray[0], max = subarray[length - 1];
        if ((max - min) % (length - 1) != 0)
            return false;
        long difference = (max - min) / (length - 1);
        for (int i = 1; i < length; i++) {
            if ((long) subarray[i] - (long) subarray[i - 1] != difference)
                return false;
        }
        return true;
    }
}