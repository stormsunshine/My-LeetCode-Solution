class Solution {
    public int longestDecomposition(String text) {
        int chunks = 0;
        int low = 0, high = text.length() - 1;
        int prevLow = low, prevHigh = high;
        int nextLow = 0;
        while (low < high) {
            while (low < high && text.charAt(low) != text.charAt(high))
                low++;
            if (low == high)
                low--;
            nextLow = low + 1;
            while (low >= prevLow) {
                if (text.charAt(low) == text.charAt(high)) {
                    low--;
                    high--;
                } else
                    break;
            }
            if (low < prevLow) {
                chunks += 2;
                prevLow = nextLow;
            } else
                high = prevHigh;
            low = nextLow;
            prevHigh = high;
        }
        if (prevLow <= prevHigh)
            chunks++;
        return chunks;
    }
}