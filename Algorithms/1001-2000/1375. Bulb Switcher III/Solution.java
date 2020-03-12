class Solution {
    public int numTimesAllBlue(int[] light) {
        int count = 1;
        int length = light.length;
        int maxConsecutive = length - 1;
        for (int i = length - 1; i > 0; i--) {
            int turnOn = light[i];
            maxConsecutive = Math.min(maxConsecutive, turnOn - 1);
            if (maxConsecutive == i)
                count++;
            else if (maxConsecutive == 0)
                break;
        }
        return count;
    }
}