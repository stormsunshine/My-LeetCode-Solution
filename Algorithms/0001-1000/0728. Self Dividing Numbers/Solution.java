class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i))
                list.add(i);
        }
        return list;
    }

    public boolean isSelfDividing(int num) {
        char[] digitsArray = String.valueOf(num).toCharArray();
        for (char c : digitsArray) {
            int digit = c - '0';
            if (digit == 0 || num % digit != 0)
                return false;
        }
        return true;
    }
}