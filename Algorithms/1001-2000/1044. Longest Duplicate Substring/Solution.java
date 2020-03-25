class Solution {
    public String longestDupSubstring(String S) {
        int length = S.length();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++)
            nums[i] = S.charAt(i) - 'a';
        int base = 26;
        final long MODULO = (long) Math.pow(2, 32);
        int low = 1, high = length;
        while (low < high) {
            int subLength = (high - low) / 2 + low;
            if (search(subLength, base, MODULO, length, nums) >= 0)
                low = subLength + 1;
            else
                high = subLength;
        }
        int start = search(low - 1, base, MODULO, length, nums);
        if (start >= 0)
            return S.substring(start, start + low - 1);
        else
            return "";
    }

    public int search(int subLength, int base, final long MODULO, int length, int[] nums) {
        long hash = 0;
        for (int i = 0; i < subLength; i++)
            hash = (hash * base + nums[i]) % MODULO;
        Set<Long> set = new HashSet<Long>();
        set.add(hash);
        long baseLong = 1;
        for (int i = 0; i < subLength; i++)
            baseLong = (baseLong * base) % MODULO;
        int maxIndex = length - subLength;
        for (int i = 1; i <= maxIndex; i++) {
            hash = (hash * base - nums[i - 1] * baseLong % MODULO + MODULO) % MODULO;
            hash = (hash + nums[i + subLength - 1]) % MODULO;
            if (set.contains(hash))
                return i;
            set.add(hash);
        }
        return -1;
    }
}