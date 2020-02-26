class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        int maxLength = String.valueOf(high).length();
        List<Long> allSteppingNumbers = new ArrayList<Long>();
        Queue<Long> queue = new LinkedList<Long>();
        allSteppingNumbers.add(0L);
        for (long i = 1; i <= 9; i++) {
            allSteppingNumbers.add(i);
            queue.offer(i);
        }
        int length = 1;
        while (length < maxLength) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long num = queue.poll();
                long lastDigit = num % 10;
                if (lastDigit > 0) {
                    long newNum = num * 10 + lastDigit - 1;
                    allSteppingNumbers.add(newNum);
                    queue.offer(newNum);
                }
                if (lastDigit < 9) {
                    long newNum = num * 10 + lastDigit + 1;
                    allSteppingNumbers.add(newNum);
                    queue.offer(newNum);
                }
            }
        }
        int startIndex = binarySearch(allSteppingNumbers, low);
        int endIndex = binarySearch(allSteppingNumbers, high);
        if (startIndex < 0)
            startIndex = -startIndex - 1;
        if (endIndex < 0)
            endIndex = -endIndex - 2;
        List<Integer> steppingNumbers = new ArrayList<Integer>();
        for (int i = startIndex; i <= endIndex; i++) {
            long numLong = allSteppingNumbers.get(i);
            steppingNumbers.add((int) numLong);
        }
        return steppingNumbers;
    }

    public int binarySearch(List<Long> list, int key) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            long num = list.get(mid);
            if (num == key)
                return mid;
            else if (num > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -low - 1;
    }
}