/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0, high = mountainArr.length() - 1;
        int lowVal = mountainArr.get(low), highVal = mountainArr.get(high);
        return findInMountainArray(target, mountainArr, low, high, lowVal, highVal);
    }

    public int findInMountainArray(int target, MountainArray mountainArr, int low, int high, int lowVal, int highVal) {
        if (target == lowVal)
            return low;
        else if (low > high || target < lowVal && target < highVal)
            return -1;
        else if (low == high)
            return target == lowVal ? low : -1;
        else if (low + 1 == high) {
            if (target == lowVal)
                return low;
            else if (target == highVal)
                return high;
            else
                return -1;
        } else {
            boolean flag = true;
            if (lowVal < highVal && highVal < target) {
                int secondHighVal = mountainArr.get(high - 1);
                if (secondHighVal < highVal)
                    flag = false;
            } else if (lowVal > highVal && lowVal < target) {
                int secondLowVal = mountainArr.get(low + 1);
                if (secondLowVal < lowVal)
                    flag = false;
            }
            if (!flag)
                return -1;
            int mid = (high - low) / 2 + low;
            int midVal = mountainArr.get(mid);
            int find1 = findInMountainArray(target, mountainArr, low, mid, lowVal, midVal);
            int find2 = findInMountainArray(target, mountainArr, mid, high, midVal, highVal);
            if (find1 >= 0)
                return find1;
            else if (find2 >= 0)
                return find2;
            else
                return -1;
        }
    }
}