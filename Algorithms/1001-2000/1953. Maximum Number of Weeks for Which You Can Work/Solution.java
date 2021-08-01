class Solution {
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        int length = milestones.length;
        int maxMilestone = milestones[length - 1];
        long sum = 0;
        for (int milestone : milestones)
            sum += milestone;
        long remaining = sum - maxMilestone;
        if (remaining >= maxMilestone)
            return sum;
        else
            return remaining * 2 + 1;
    }
}