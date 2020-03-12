class Solution {
    public String minimizeError(String[] prices, int target) {
        int length = prices.length;
        int[] priceArray = new int[length];
        int[] minArray = new int[length];
        int[] maxArray = new int[length];
        int minSum = 0, maxSum = 0, errorSum = 0;
        for (int i = 0; i < length; i++) {
            String priceStr = prices[i];
            int pointIndex = priceStr.indexOf('.');
            String iPart = priceStr.substring(0, pointIndex);
            String fPart = priceStr.substring(pointIndex + 1);
            int price = Integer.parseInt(iPart) * 1000 + Integer.parseInt(fPart);
            priceArray[i] = price;
            if (price % 1000 == 0) {
                minArray[i] = price;
                maxArray[i] = price;
            } else {
                minArray[i] = price / 1000 * 1000;
                maxArray[i] = minArray[i] + 1000;
            }
            minSum += minArray[i];
            maxSum += maxArray[i];
            errorSum += price - minArray[i];
        }
        int targetThousand = target * 1000;
        if (targetThousand > maxSum || targetThousand < minSum)
            return "-1";
        int difference = targetThousand - minSum;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 % 1000 - num1 % 1000;
            }
        });
        for (int i = 0; i < length; i++)
            priorityQueue.offer(priceArray[i]);
        for (int i = 0; i < difference; i += 1000) {
            int price = priorityQueue.poll();
            int remainder = price % 1000;
            int newRemainder = 1000 - remainder;
            errorSum -= (remainder - newRemainder);
        }
        String minErrorIPart = String.valueOf(errorSum / 1000);
        String minErrorFPart = String.format("%03d", errorSum % 1000);
        String minError = minErrorIPart + "." + minErrorFPart;
        return minError;
    }
}