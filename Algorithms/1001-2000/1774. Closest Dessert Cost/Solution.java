class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int closest = Integer.MAX_VALUE;
        for (int baseCost : baseCosts)
            closest = Math.min(closest, baseCost);
        int minDifference = Math.abs(closest - target);
        int toppingsCount = toppingCosts.length;
        int totalToppings = (int) Math.pow(3, toppingsCount);
        for (int i = 0; i < totalToppings; i++) {
            int[] combination = getCombination(toppingsCount, i);
            int toppingCost = getToppingCost(toppingCosts, combination);
            for (int baseCost : baseCosts) {
                int totalCost = toppingCost + baseCost;
                int difference = Math.abs(totalCost - target);
                if (difference < minDifference || difference == minDifference && totalCost < closest) {
                    closest = totalCost;
                    minDifference = difference;
                }
            }
        }
        return closest;
    }

    public int[] getCombination(int length, int index) {
        int[] combination = new int[length];
        for (int i = length - 1; i >= 0 && index > 0; i--) {
            int remainder = index % 3;
            combination[i] = remainder;
            index /= 3;
        }
        return combination;
    }

    public int getToppingCost(int[] toppingCosts, int[] combination) {
        int cost = 0;
        int length = toppingCosts.length;
        for (int i = 0; i < length; i++)
            cost += toppingCosts[i] * combination[i];
        return cost;
    }
}