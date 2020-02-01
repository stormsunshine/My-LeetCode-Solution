/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1])
            return sea.hasShips(topRight, bottomLeft) ? 1 : 0;
        else if (topRight[0] == bottomLeft[0]) {
            int midY = (topRight[1] + bottomLeft[1]) / 2;
            int[] topRightMid = {topRight[0], midY};
            int[] bottomLeftMid = {bottomLeft[0], midY + 1};
            int ships = 0;
            if (sea.hasShips(topRightMid, bottomLeft))
                ships += countShips(sea, topRightMid, bottomLeft);
            if (sea.hasShips(topRight, bottomLeftMid))
                ships += countShips(sea, topRight, bottomLeftMid);
            return ships;
        } else if (topRight[1] == bottomLeft[1]) {
            int midX = (topRight[0] + bottomLeft[0]) / 2;
            int[] topRightMid = {midX, topRight[1]};
            int[] bottomLeftMid = {midX + 1, bottomLeft[1]};
            int ships = 0;
            if (sea.hasShips(topRightMid, bottomLeft))
                ships += countShips(sea, topRightMid, bottomLeft);
            if (sea.hasShips(topRight, bottomLeftMid))
                ships += countShips(sea, topRight, bottomLeftMid);
            return ships;
        } else {
            int midX = (topRight[0] + bottomLeft[0]) / 2, midY = (topRight[1] + bottomLeft[1]) / 2;
            int[] topRight1 = {midX, midY};
            int[] bottomLeft1 = {bottomLeft[0], bottomLeft[1]};
            int[] topRight2 = {topRight[0], midY};
            int[] bottomLeft2 = {midX + 1, bottomLeft[1]};
            int[] topRight3 = {midX, topRight[1]};
            int[] bottomLeft3 = {bottomLeft[0], midY + 1};
            int[] topRight4 = {topRight[0], topRight[1]};
            int[] bottomLeft4 = {midX + 1, midY + 1};
            int ships = 0;
            if (sea.hasShips(topRight1, bottomLeft1))
                ships += countShips(sea, topRight1, bottomLeft1);
            if (sea.hasShips(topRight2, bottomLeft2))
                ships += countShips(sea, topRight2, bottomLeft2);
            if (sea.hasShips(topRight3, bottomLeft3))
                ships += countShips(sea, topRight3, bottomLeft3);
            if (sea.hasShips(topRight4, bottomLeft4))
                ships += countShips(sea, topRight4, bottomLeft4);
            return ships;
        }
    }
}