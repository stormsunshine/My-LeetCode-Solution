class Solution {
    public int numDupDigitsAtMostN(int N) {
        if (N <= 10)
            return 0;
        int duplicates = 0;
        int length = String.valueOf(N).length();
        for (int i = 2; i < length; i++)
            duplicates += dupNums(i);
        Set<Integer> usedDigits = new HashSet<Integer>();
        int curNum = (int) Math.pow(10, length - 1);
        int curLength = length - 1;
        int unit = curNum;
        boolean flag = false;
        while (unit > 1) {
            int lastDigit = N / unit % 10;
            int upperBound = N / unit * unit;
            while (curNum < upperBound) {
                int curDigit = curNum / unit % 10;
                int curCount = 0;
                if (!usedDigits.contains(curDigit)) {
                    curCount = 1;
                    int start = 9 - usedDigits.size();
                    for (int i = 0; i < curLength; i++)
                        curCount *= start - i;
                }
                duplicates += unit - curCount;
                curNum += unit;
            }
            if (usedDigits.add(lastDigit)) {
                curLength--;
                unit /= 10;
            } else {
                flag = true;
                break;
            }
        }
        if (flag)
            duplicates += N - curNum + 1;
        else {
            while (curNum <= N) {
                int lastDigit = curNum % 10;
                if (usedDigits.contains(lastDigit))
                    duplicates++;
                curNum++;
            }
        }
        return duplicates;
    }

    public int dupNums(int length) {
        int distincts = 9;
        for (int i = 1; i < length; i++)
            distincts *= 10 - i;
        return 9 * (int) Math.pow(10, length - 1) - distincts;
    }
}