class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int length = time.length;
        int[] remainder = new int[length];
        for (int i = 0; i < length; i++)
            remainder[i] = time[i] % 60;
        Arrays.sort(remainder);
        int beginIndex = 0;
        while (beginIndex < length && remainder[beginIndex] == 0)
            beginIndex++;
        int pairs = beginIndex * (beginIndex - 1) / 2;
        int low = beginIndex, high = length - 1;
        while (low < high) {
            int sum = remainder[low] + remainder[high];
            if (sum < 60)
                low++;
            else if (sum > 60)
                high--;
            else {
                if (remainder[low] == 30) {
                    int count = high - low + 1;
                    pairs += count * (count - 1) / 2;
                    break;
                } else {
                    int lowEnd = low, highEnd = high;
                    int remainderLow = remainder[low], remainderHigh = remainder[high];
                    while (lowEnd < high && remainder[lowEnd] == remainderLow)
                        lowEnd++;
                    while (highEnd > low && remainder[highEnd] == remainderHigh)
                        highEnd--;
                    pairs += (lowEnd - low) * (high - highEnd);
                    low = lowEnd;
                    high = highEnd;
                }
            }
        }
        return pairs;
    }
}