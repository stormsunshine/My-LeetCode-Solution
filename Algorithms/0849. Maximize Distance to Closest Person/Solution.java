class Solution {
    public int maxDistToClosest(int[] seats) {
        int length = seats.length;
        int leftMostOne = -1, rightMostOne = length;
        for (int i = 0; i < length; i++) {
            if (seats[i] == 1) {
                leftMostOne = i;
                break;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                rightMostOne = i;
                break;
            }
        }
        int maxDistance = Math.max(leftMostOne, length - 1 - rightMostOne);
        int prevOne = leftMostOne;
        for (int i = leftMostOne; i <= rightMostOne; i++) {
            if (seats[i] == 1) {
                int onesDistance = i - prevOne;
                int curDistance = onesDistance / 2;
                maxDistance = Math.max(maxDistance, curDistance);
                prevOne = i;
            }
        }
        return maxDistance;
    }
}