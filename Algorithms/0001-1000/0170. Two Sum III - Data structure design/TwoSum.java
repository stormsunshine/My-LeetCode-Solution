class TwoSum {
    List<Integer> numsList;
    int size;

    /** Initialize your data structure here. */
    public TwoSum() {
        numsList = new ArrayList<Integer>();
        size = 0;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (size == 0)
            numsList.add(number);
        else {
            int index = binarySearch(number);
            if (index < 0)
                index = -index - 1;
            numsList.add(index, number);
        }
        size++;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int low = 0, high = size - 1;
        while (low < high) {
            int curSum = numsList.get(low) + numsList.get(high);
            if (curSum == value)
                return true;
            else if (curSum > value)
                high--;
            else
                low++;
        }
        return false;
    }

    private int binarySearch(int number) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int curNum = numsList.get(mid);
            if (curNum == number)
                return mid;
            else if (curNum > number)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */