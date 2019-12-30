class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        if (high == 1000000000)
            high--;
        List<Integer> list = new ArrayList<Integer>();
        int lengthLow = String.valueOf(low).length(), lengthHigh = String.valueOf(high).length();
        List<Integer> listLow = sequentialDigitsWithLength(lengthLow);
        for (int num : listLow) {
            if (num > high)
                break;
            if (num >= low)
                list.add(num);
        }
        for (int i = lengthLow + 1; i < lengthHigh; i++) {
            List<Integer> listWithLength = sequentialDigitsWithLength(i);
            for (int num : listWithLength)
                list.add(num);
        }
        List<Integer> listHigh = sequentialDigitsWithLength(lengthHigh);
        if (lengthLow < lengthHigh) {
            for (int num : listHigh) {
                if (num <= high)
                    list.add(num);
                else
                    break;
            }
        }
        return list;
    }

    public List<Integer> sequentialDigitsWithLength(int length) {
        List<Integer> list = new ArrayList<Integer>();
        int begin = 1, end = 9 - length + 1;
        int num = 0;
        int inc = 0;
        int digit = 1;
        while (digit <= length) {
            num *= 10;
            num += digit;
            digit++;
            inc *= 10;
            inc++;
        }
        for (int i = begin; i <= end; i++) {
            list.add(num);
            num += inc;
        }
        return list;
    }
}