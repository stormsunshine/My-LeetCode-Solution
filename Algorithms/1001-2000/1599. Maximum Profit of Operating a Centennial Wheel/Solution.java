class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = 0;
        int maxProfitOperations = -1;
        int totalProfit = 0;
        int customersCount = 0;
        int length = customers.length;
        for (int i = 0; i < length; i++) {
            customersCount += customers[i];
            int curCustomers = Math.min(customersCount, 4);
            customersCount -= curCustomers;
            totalProfit += boardingCost * curCustomers - runningCost;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitOperations = i + 1;
            }
        }
        int operations = length;
        while (customersCount > 0) {
            operations++;
            int curCustomers = Math.min(customersCount, 4);
            customersCount -= curCustomers;
            totalProfit += boardingCost * curCustomers - runningCost;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                maxProfitOperations = operations;
            }
        }
        return maxProfitOperations;
    }
}