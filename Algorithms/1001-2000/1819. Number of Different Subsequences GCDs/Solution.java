class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 1];
        for (int num : set) {
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    counts[i]++;
                    if (i * i != num)
                        counts[num / i]++;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (set.contains(i))
                count++;
            else if (counts[i] > 0) {
                boolean flag = true;
                for (int j = i * 2; j <= max; j += i) {
                    if (counts[j] == counts[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    count++;
            }
        }
        return count;
    }
}