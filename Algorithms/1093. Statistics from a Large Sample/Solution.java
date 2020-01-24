class Solution {
    public double[] sampleStats(int[] count) {
        int length = count.length;
        double min = -1, max = -1, mode = -1;
        int modeCount = 0;
        double sum = 0;
        int totalCount = 0;
        for (int i = 0; i < length; i++) {
            int curCount = count[i];
            if (curCount > 0) {
                if (min < 0)
                    min = i;
                max = i;
                sum += i * curCount;
                totalCount += curCount;
                if (curCount > modeCount) {
                    modeCount = curCount;
                    mode = i;
                }
            }
        }
        double mean = sum / totalCount;
        double median = 0;
        int countMedian = 0;
        int prev = -1;
        for (int i = 0; i < length; i++) {
            int curCount = count[i];
            if (curCount > 0) {
                if (totalCount % 2 == 0) {
                    if (countMedian * 2 == totalCount) {
                        median = (prev + i) / 2.0;
                        break;
                    } else {
                        countMedian += curCount;
                        if (countMedian * 2 > totalCount) {
                            median = i;
                            break;
                        }
                    }
                } else {
                    countMedian += curCount;
                    if (countMedian * 2 > totalCount) {
                        median = i;
                        break;
                    }
                }
                prev = i;
            }
        }
        return new double[]{min, max, mean, median, mode};
    }
}