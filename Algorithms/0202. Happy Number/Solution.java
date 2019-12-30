class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int num = n;
        set.add(num);
        while (num != 1) {
            num = getNextNumber(num);
            if (!set.add(num))
                break;
        }
        return num == 1;
    }

    public int getNextNumber(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int sum = 0;
        for (char c : array) {
            int digit = c - '0';
            sum += digit * digit;
        }
        return sum;
    }
}